package com.nyxelis.service.impl;

import com.nyxelis.entity.Component;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.repository.ComponentRepository;
import com.nyxelis.service.IComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService implements IComponentService {

  @Autowired
  private ComponentRepository componentRepository;

  @Override
  public Component saveComponent(Component component) {
    return componentRepository.save(component);
  }

  @Override
  public void deleteComponent(Long id) {
    componentRepository.deleteById(id);
  }

  @Override
  public Component getComponentById(Long id) {
    return componentRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Component not found"));
  }

  @Override
  public List<Component> getComponentsByComponentType(ComponentType componentType) {
    return componentRepository.findByType(componentType);
  }
}
