package com.nyxelis.controller;

import com.nyxelis.dto.DtoComponent;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.enums.ComponentType;

import java.util.List;

public interface IComponentController {
  RootEntityResponse<DtoComponent> createComponent(DtoComponent dtoComponent);

  RootEntityResponse<DtoComponent> updateComponent(Long id, DtoComponent dtoComponent);

  void deleteComponent(Long id);

  RootEntityResponse<DtoComponent> getComponentById(Long id);

  RootEntityResponse<List<DtoComponent>> getComponentsByComponentType(ComponentType componentType);
}
