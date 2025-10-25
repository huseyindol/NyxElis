package com.nyxelis.service;

import com.nyxelis.entity.Component;
import com.nyxelis.enums.ComponentType;

import java.util.List;

public interface IComponentService {
  Component getComponentById(Long id);

  Component saveComponent(Component component);

  void deleteComponent(Long id);

  List<Component> getComponentsByComponentType(ComponentType componentType);
}
