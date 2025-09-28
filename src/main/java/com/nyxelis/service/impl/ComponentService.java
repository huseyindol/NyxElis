package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoComponent;
import com.nyxelis.entity.Component;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.mapper.ComponentMapper;
import com.nyxelis.repository.ComponentRepository;
import com.nyxelis.service.IComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService implements IComponentService {

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private ComponentMapper componentMapper;

    @Override
    public DtoComponent createComponent(DtoComponent dtoComponent) {
        Component component = componentMapper.toComponentEntity(dtoComponent);
        Component saved = componentRepository.save(component);
        return componentMapper.toComponentDto(saved);
    }

    @Override
    public DtoComponent updateComponent(Long id, DtoComponent dtoComponent) {
        Component component = componentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found"));
        componentMapper.updateComponentEntityFromDto(dtoComponent, component);
        Component saved = componentRepository.save(component);
        return componentMapper.toComponentDto(saved);
    }

    @Override
    public void deleteComponent(Long id) {
        componentRepository.deleteById(id);
    }

    @Override
    public DtoComponent getComponentById(Long id) {
        Component component = componentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found"));
        return componentMapper.toComponentDto(component);
    }

    @Override
    public List<DtoComponent> getComponentsByComponentType(ComponentType componentType) {
        List<Component> components = componentRepository.findByType(componentType);
        return componentMapper.toComponentDtoList(components);
    }

    // @Override
    // public List<DtoComponent> getComponentsByPageId(Long pageId) {
    // List<Component> components =
    // componentRepository.findByPageComponentsPageId(pageId);
    // return componentMapper.toDtoIUList(components);
    // }
}
