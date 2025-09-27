package com.nyxelis.controller;

import com.nyxelis.dto.DtoComponent;
import com.nyxelis.enums.ComponentType;

import java.util.List;

public interface IComponentController {
    public DtoComponent createComponent(DtoComponent dtoComponent);
    public DtoComponent updateComponent(Long id, DtoComponent dtoComponent);
    public void deleteComponent(Long id);
    public DtoComponent getComponentById(Long id);
    public List<DtoComponent> getComponentsByComponentType(ComponentType componentType);
    // public List<DtoComponent> getComponentsByPageId(Long pageId);
}
