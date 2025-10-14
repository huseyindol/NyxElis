package com.nyxelis.controller.impl;

import com.nyxelis.controller.IComponentController;
import com.nyxelis.dto.DtoComponent;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.service.IComponentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nyxelis.entity.RootEntityResponse.ok;

@RestController
@RequestMapping("/api/component")
@Tag(name = "Component Services")
public class ComponentController implements IComponentController {

  @Autowired
  private IComponentService componentService;

  @Override
  @PostMapping("/create")
  public RootEntityResponse<DtoComponent> createComponent(@RequestBody DtoComponent dtoComponent) {
    return ok(componentService.createComponent(dtoComponent));
  }

  @Override
  @PutMapping("/{id}")
  public RootEntityResponse<DtoComponent> updateComponent(@PathVariable(value = "id") Long id,
                                                          @RequestBody DtoComponent dtoComponent) {
    return ok(componentService.updateComponent(id, dtoComponent));
  }

  @Override
  @DeleteMapping("/{id}")
  public void deleteComponent(@PathVariable(value = "id") Long id) {
    componentService.deleteComponent(id);
  }

  @Override
  @GetMapping("/{id}")
  public RootEntityResponse<DtoComponent> getComponentById(@PathVariable(value = "id") Long id) {
    return ok(componentService.getComponentById(id));
  }

  @Override
  @GetMapping("/byType/{componentType}")
  public RootEntityResponse<List<DtoComponent>> getComponentsByComponentType(@PathVariable ComponentType componentType) {
    return ok(componentService.getComponentsByComponentType(componentType));
  }

  // @GetMapping("/byPageId/{pageId}")
  // @Override
  // public List<DtoComponent> getComponentsByPageId(@PathVariable Long pageId)
  // {
  // return componentService.getComponentsByPageId(pageId);
  // }
}
