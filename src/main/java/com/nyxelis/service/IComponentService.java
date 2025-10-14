package com.nyxelis.service;

import com.nyxelis.dto.DtoComponent;
import com.nyxelis.enums.ComponentType;

import java.util.List;

public interface IComponentService {
  DtoComponent createComponent(DtoComponent dtoComponent);

  DtoComponent updateComponent(Long id, DtoComponent dtoComponent);

  void deleteComponent(Long id);

  DtoComponent getComponentById(Long id);

  List<DtoComponent> getComponentsByComponentType(ComponentType componentType);
  // public List<DtoComponent> getComponentsByPageId(Long pageId);
}
