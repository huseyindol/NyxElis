package com.nyxelis.controller.impl;

import com.nyxelis.controller.IComponentController;
import com.nyxelis.dto.DtoComponent;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.service.IComponentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/component")
@Tag(name = "Component Services")
public class ComponentController implements IComponentController {

    @Autowired
    private IComponentService componentService;

    @PostMapping("/create")
    @Override
    public DtoComponent createComponent(@RequestBody DtoComponent dtoComponent) {
        return componentService.createComponent(dtoComponent);
    }

    @PostMapping("/update/{id}")
    @Override
    public DtoComponent updateComponent(@PathVariable(name = "id") Long id, @RequestBody DtoComponent dtoComponent) {
        return componentService.updateComponent(id, dtoComponent);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteComponent(@PathVariable(name = "id") Long id) {
        componentService.deleteComponent(id);
    }

    @GetMapping("/{id}")
    @Override
    public DtoComponent getComponentById(@PathVariable(name = "id") Long id) {
        return componentService.getComponentById(id);
    }

    @GetMapping("/byType/{componentType}")
    @Override
    public List<DtoComponent> getComponentsByComponentType(@PathVariable ComponentType componentType) {
        return componentService.getComponentsByComponentType(componentType);
    }

    // @GetMapping("/byPageId/{pageId}")
    // @Override
    // public List<DtoComponent> getComponentsByPageId(@PathVariable Long pageId)
    // {
    // return componentService.getComponentsByPageId(pageId);
    // }
}
