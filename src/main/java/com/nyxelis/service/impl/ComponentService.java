package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoComponentIU;
import com.nyxelis.entity.Component;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.mapper.ComponentMapper;
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
    public DtoComponentIU createComponent(DtoComponentIU dtoComponentIU) {
        Component component = ComponentMapper.INSTANCE.toEntityIU(dtoComponentIU);
        Component saved = componentRepository.save(component);
        return ComponentMapper.INSTANCE.toDtoIU(saved);
    }

    @Override
    public DtoComponentIU updateComponent(Long id, DtoComponentIU dtoComponentIU) {
        Component component = componentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found"));
        ComponentMapper.INSTANCE.updateEntityFromDto(dtoComponentIU, component);
        Component saved = componentRepository.save(component);
        return ComponentMapper.INSTANCE.toDtoIU(saved);
    }

    @Override
    public void deleteComponent(Long id) {
        componentRepository.deleteById(id);
    }

    @Override
    public DtoComponentIU getComponentById(Long id) {
        Component component = componentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found"));
        return ComponentMapper.INSTANCE.toDtoIU(component);
    }

    @Override
    public List<DtoComponentIU> getComponentsByComponentType(ComponentType componentType) {
        List<Component> components = componentRepository.findByType(componentType);
        return ComponentMapper.INSTANCE.toDtoIUList(components);
    }

    // @Override
    // public List<DtoComponentIU> getComponentsByPageId(Long pageId) {
    // List<Component> components =
    // componentRepository.findByPageComponentsPageId(pageId);
    // return ComponentMapper.INSTANCE.toDtoIUList(components);
    // }
}
