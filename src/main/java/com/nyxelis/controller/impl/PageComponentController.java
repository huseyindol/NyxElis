package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPageComponentController;
import com.nyxelis.dto.DtoPageComponent;
import com.nyxelis.dto.DtoPageComponentIU;
import com.nyxelis.service.IPageComponentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/page-component")
@Tag(name = "Page Component Services")
public class PageComponentController implements IPageComponentController {

  @Autowired
  private IPageComponentService pageComponentService;

  @Override
  @PostMapping("/add")
  public DtoPageComponentIU addComponentToPage(@RequestBody DtoPageComponentIU dtoPageComponent) {
    return pageComponentService.addComponentToPage(dtoPageComponent);
  }

  @Override
  @PutMapping("/reorder")
  public void reorderComponents(@RequestBody List<DtoPageComponentIU> dtoOfPageComponent) {
    pageComponentService.reorderComponents(dtoOfPageComponent);
  }

//    @Override
//    @DeleteMapping("/delete/{pageId}/{componentId}")
//    public void removeComponentFromPage(@PathVariable Long pageId, @PathVariable Long componentId) {
//        pageComponentService.removeComponentFromPage(pageId, componentId);
//    }

  @Override
  @GetMapping("/{pageId}")
  public List<DtoPageComponent> getComponentsOfPage(@PathVariable Long pageId) {
    return pageComponentService.getComponentsOfPage(pageId);
  }
}
