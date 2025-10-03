package com.nyxelis.controller;

import com.nyxelis.dto.DtoComponent;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.enums.ComponentType;

import java.util.List;

public interface IComponentController {
    public RootEntityResponse<DtoComponent> createComponent(DtoComponent dtoComponent);
    public RootEntityResponse<DtoComponent> updateComponent(Long id, DtoComponent dtoComponent);
    public void deleteComponent(Long id);
    public RootEntityResponse<DtoComponent> getComponentById(Long id);
    public RootEntityResponse<List<DtoComponent>> getComponentsByComponentType(ComponentType componentType);
}
