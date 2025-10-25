package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPageComponentController;
import com.nyxelis.dto.DtoPageComponent;
import com.nyxelis.dto.DtoPageComponentIU;
import com.nyxelis.entity.Component;
import com.nyxelis.entity.Page;
import com.nyxelis.entity.PageComponent;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.mapper.PageComponentMapper;
import com.nyxelis.service.IPageComponentService;
import com.nyxelis.service.impl.ComponentService;
import com.nyxelis.service.impl.PageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nyxelis.entity.RootEntityResponse.ok;

@RestController
@RequestMapping("/api/page-component")
@Tag(name = "Page Component Services")
public class PageComponentController implements IPageComponentController {

  @Autowired
  private IPageComponentService pageComponentService;
  @Autowired
  private PageService pageService;
  @Autowired
  private ComponentService componentService;
  @Autowired
  private PageComponentMapper pageComponentMapper;

  @Override
  @PostMapping("/add")
  public RootEntityResponse<DtoPageComponentIU> addComponentToPage(@RequestBody DtoPageComponentIU dtoPageComponent) {
    Page page = pageService.pageFindById(dtoPageComponent.getPageId());
    Component component =
      componentService.getComponentById(dtoPageComponent.getComponentId());

    PageComponent pageComponent = new PageComponent();
    pageComponent.setPage(page);
    pageComponent.setComponent(component);
    pageComponent.setOrderIndex(dtoPageComponent.getOrderIndex());

    return ok(pageComponentMapper.toPageComponentIUDto(pageComponentService.addComponentToPage(pageComponent)));
  }

  @Override
  @PutMapping("/reorder")
  public void reorderComponents(@RequestBody List<DtoPageComponentIU> dtoOfPageComponent) {
    pageComponentService.reorderComponents(dtoOfPageComponent);
  }

  @Override
  @GetMapping("/{pageId}")
  public RootEntityResponse<List<DtoPageComponent>> getComponentsOfPage(@PathVariable Long pageId) {
    return ok(pageComponentMapper.toPageComponentDtoList(pageComponentService.getComponentsOfPage(pageId)));
  }
}
