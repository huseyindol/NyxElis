package com.nyxelis.controller;

import com.nyxelis.dto.DtoPageComponent;

import java.util.List;

public interface IPageComponentController {
    public DtoPageComponent addComponentToPage(DtoPageComponent dtoPageComponent);
    public void reorderComponents(List<DtoPageComponent> dtoOfPageComponent);
    public void removeComponentFromPage(Long pageId, Long componentId);
    public List<DtoPageComponent> getComponentsOfPage(Long pageId);
}
