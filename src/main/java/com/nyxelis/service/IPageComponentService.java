package com.nyxelis.service;

import com.nyxelis.dto.DtoPageComponent;
import com.nyxelis.dto.DtoPageComponentIU;

import java.util.List;

public interface IPageComponentService {
  List<DtoPageComponent> getComponentsOfPage(Long pageId);

  DtoPageComponentIU addComponentToPage(DtoPageComponentIU dtoPageComponent);

  void reorderComponents(List<DtoPageComponentIU> dtoOfPageComponent);
//    public void removeComponentFromPage(Long pageId, Long componentId);
}
