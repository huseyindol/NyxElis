package com.nyxelis.controller.impl;

import com.nyxelis.controller.IComponentController;
import com.nyxelis.dto.DtoComponent;
import com.nyxelis.entity.Component;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.mapper.ComponentMapper;
import com.nyxelis.service.IComponentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/component")
@Tag(name = "Component Services")
public class ComponentController extends BaseController implements IComponentController {

  @Autowired
  private IComponentService componentService;

  @Autowired
  private ComponentMapper componentMapper;

  @Override
  @PostMapping("/create")
  public RootEntityResponse<DtoComponent> createComponent(@RequestBody DtoComponent dtoComponent) {
    return ok(componentMapper.toComponentDto(componentService.saveComponent(componentMapper.toComponentEntity(dtoComponent))));
  }

  @Override
  @PutMapping("/{id}")
  public RootEntityResponse<DtoComponent> updateComponent(@PathVariable(value = "id") Long id, @RequestBody DtoComponent dtoComponent) {
    Component existingComponent = componentService.getComponentById(id);
    componentMapper.updateComponentEntityFromDto(dtoComponent, existingComponent);
    return ok(componentMapper.toComponentDto(componentService.saveComponent(existingComponent)));
  }

  @Override
  @DeleteMapping("/{id}")
  public void deleteComponent(@PathVariable(value = "id") Long id) {
    componentService.deleteComponent(id);
  }

  @Override
  @GetMapping("/{id}")
  public RootEntityResponse<DtoComponent> getComponentById(@PathVariable(value = "id") Long id) {
    return ok(componentMapper.toComponentDto(componentService.getComponentById(id)));
  }

  @Override
  @GetMapping("/byType/{componentType}")
  public RootEntityResponse<List<DtoComponent>> getComponentsByComponentType(@PathVariable ComponentType componentType) {
    return ok(componentMapper.toComponentDtoList(componentService.getComponentsByComponentType(componentType)));
  }

  // @GetMapping("/byPageId/{pageId}")
  // @Override
  // public List<DtoComponent> getComponentsByPageId(@PathVariable Long pageId)
  // {
  // return componentService.getComponentsByPageId(pageId);
  // }
}
