package com.nyxelis.service;

import com.nyxelis.dto.DtoPageComponentIU;
import com.nyxelis.entity.PageComponent;

import java.util.List;

public interface IPageComponentService {
  List<PageComponent> getComponentsOfPage(Long pageId);

  PageComponent addComponentToPage(PageComponent pageComponent);

  void reorderComponents(List<DtoPageComponentIU> pageComponents);
}
