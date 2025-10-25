package com.nyxelis.controller;

import com.nyxelis.dto.DtoPageComponent;
import com.nyxelis.dto.DtoPageComponentIU;
import com.nyxelis.entity.RootEntityResponse;

import java.util.List;

public interface IPageComponentController {
  RootEntityResponse<List<DtoPageComponent>> getComponentsOfPage(Long pageId);

  RootEntityResponse<DtoPageComponentIU> addComponentToPage(DtoPageComponentIU dtoPageComponent);

  void reorderComponents(List<DtoPageComponentIU> dtoOfPageComponent);
//    public void removeComponentFromPage(Long pageId, Long componentId);
}
