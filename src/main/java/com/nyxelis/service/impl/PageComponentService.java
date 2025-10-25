package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoPageComponentIU;
import com.nyxelis.entity.PageComponent;
import com.nyxelis.entity.id.PageComponentId;
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
  public PageComponent addComponentToPage(PageComponent pageComponent) {
    return pageComponentRepository.save(pageComponent);
  }

  @Override
  @Transactional
  public void reorderComponents(List<DtoPageComponentIU> pageComponents) {
    for (DtoPageComponentIU existPC : pageComponents) {
      PageComponentId id = new PageComponentId(
        existPC.getPageId(),
        existPC.getComponentId()
      );
      PageComponent pc = pageComponentRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("PageComponent not found with id: " + id));

      pc.setOrderIndex(existPC.getOrderIndex());
    }
  }

  @Override
  public List<PageComponent> getComponentsOfPage(Long pageId) {
    return pageComponentRepository.findByPageId(pageId);
  }
}
