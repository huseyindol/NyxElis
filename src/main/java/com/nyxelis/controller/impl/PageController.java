package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPageController;
import com.nyxelis.dto.DtoPage;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.service.IPageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/page")
@Tag(name = "Page Services")
public class PageController extends BaseController implements IPageController {

  @Autowired
  private IPageService pageService;

  @Override
  @GetMapping("/{slug}")
  public RootEntityResponse<DtoPage> pageFindBySlug(@PathVariable(value = "slug") String slug) {
    return ok(pageService.pageFindBySlug(slug));
  }

  @Override
  @PostMapping("/create")
  public RootEntityResponse<DtoPage> createPage(@RequestBody DtoPage dtoPage) {
    return ok(pageService.createPage(dtoPage));
  }

  @Override
  @PutMapping("/{id}")
  public RootEntityResponse<DtoPage> updatePage(@PathVariable(value = "id") Long id, @RequestBody DtoPage dtoPage) {
    return ok(pageService.updatePage(id, dtoPage));
  }

  @Override
  @DeleteMapping("/{id}")
  public void deletePage(@PathVariable(value = "id") Long id) {
    pageService.deletePage(id);
  }

}
