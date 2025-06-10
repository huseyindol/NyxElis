package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoPageComponent;
import com.nyxelis.entity.Component;
import com.nyxelis.entity.Page;
import com.nyxelis.entity.PageComponent;
import com.nyxelis.entity.id.PageComponentId;
import com.nyxelis.mapper.PageComponentMapper;
import com.nyxelis.repository.ComponentRepository;
import com.nyxelis.repository.PageComponentRepository;
import com.nyxelis.repository.PageRepository;
import com.nyxelis.service.IPageComponentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageComponentService implements IPageComponentService {

    @Autowired
    private PageComponentRepository pageComponentRepository;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ComponentRepository componentRepository;

    @Override
    public DtoPageComponent addComponentToPage(DtoPageComponent dtoPageComponent) {
        Page page = pageRepository.findById(dtoPageComponent.getPageId())
                .orElseThrow(() -> new IllegalArgumentException("Page not found"));

        Component component = componentRepository.findById(dtoPageComponent.getComponentId())
                .orElseThrow(() -> new IllegalArgumentException("Component not found"));

        PageComponent entity = new PageComponent();
        entity.setPage(page);
        entity.setComponent(component);
        entity.setOrderIndex(dtoPageComponent.getOrderIndex());

        PageComponentId id = new PageComponentId(dtoPageComponent.getPageId(), dtoPageComponent.getComponentId());
        entity.setId(id);

        PageComponent savedEntity = pageComponentRepository.save(entity);
        return PageComponentMapper.INSTANCE.toPageComponentDto(savedEntity);
    }

    @Override
    @Transactional
    public void reorderComponents(List<DtoPageComponent> dtoOfPageComponent) {
        for (DtoPageComponent dto : dtoOfPageComponent) {
            PageComponentId id = new PageComponentId(dto.getPageId(), dto.getComponentId());
            PageComponent pc = pageComponentRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("PageComponent not found with id: " + id));

            pc.setOrderIndex(dto.getOrderIndex());
            // JPA, transactinal içinde olduğu için save işlemi gereksiz, çünkü
            // değişiklikler otomatik olarak kaydedilir
            // pageComponentRepository.save(pc); // Not needed, changes are automatically
            // flushed
        }
    }

    @Override
    public void removeComponentFromPage(Long pageId, Long componentId) {
        PageComponentId id = new PageComponentId(pageId, componentId);
        pageComponentRepository.deleteById(id);
    }

    @Override
    public List<DtoPageComponent> getComponentsOfPage(Long pageId) {
        List<PageComponent> pageComponents = pageComponentRepository.findByPageId(pageId);
        return PageComponentMapper.INSTANCE.toPageComponentDtoList(pageComponents);
    }
}
