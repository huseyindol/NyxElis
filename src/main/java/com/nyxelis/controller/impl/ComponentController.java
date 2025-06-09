package com.nyxelis.controller.impl;

import com.nyxelis.controller.IComponentController;
import com.nyxelis.dto.DtoComponentIU;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.service.IComponentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/component")
public class ComponentController implements IComponentController {

    @Autowired
    private IComponentService componentService;

    @PostMapping("/create")
    @Override
    public DtoComponentIU createComponent(@RequestBody DtoComponentIU dtoComponentIU) {
        return componentService.createComponent(dtoComponentIU);
    }

    @PostMapping("/update/{id}")
    @Override
    public DtoComponentIU updateComponent(@PathVariable(name = "id") Long id,
            @RequestBody DtoComponentIU dtoComponentIU) {
        return componentService.updateComponent(id, dtoComponentIU);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteComponent(@PathVariable(name = "id") Long id) {
        componentService.deleteComponent(id);
    }

    @GetMapping("/{id}")
    @Override
    public DtoComponentIU getComponentById(@PathVariable(name = "id") Long id) {
        return componentService.getComponentById(id);
    }

    @GetMapping("/byType/{componentType}")
    @Override
    public List<DtoComponentIU> getComponentsByComponentType(@PathVariable ComponentType componentType) {
        return componentService.getComponentsByComponentType(componentType);
    }

    // @GetMapping("/byPageId/{pageId}")
    // @Override
    // public List<DtoComponentIU> getComponentsByPageId(@PathVariable Long pageId)
    // {
    // return componentService.getComponentsByPageId(pageId);
    // }

}
