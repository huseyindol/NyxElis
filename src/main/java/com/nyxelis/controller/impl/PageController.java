package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPageController;
import com.nyxelis.dto.DtoPage;
import com.nyxelis.entity.Page;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.mapper.PageMapper;
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
  @Autowired
  private PageMapper pageMapper;

  @Override
  @GetMapping("/{slug}")
  public RootEntityResponse<DtoPage> pageFindBySlug(@PathVariable(value = "slug") String slug) {
    return ok(pageMapper.toPageDto(pageService.pageFindBySlug(slug)));
  }

  @Override
  @PostMapping("/create")
  public RootEntityResponse<DtoPage> createPage(@RequestBody DtoPage dtoPage) {
    Page pageEntity = pageMapper.toPageEntity(dtoPage);
    return ok(pageMapper.toPageDto(pageService.savePage(pageEntity)));
  }

  @Override
  @PutMapping("/{id}")
  public RootEntityResponse<DtoPage> updatePage(@PathVariable(value = "id") Long id, @RequestBody DtoPage dtoPage) {
    Page page = pageService.pageFindById(id);
    pageMapper.updatePageEntityFromDto(dtoPage, page);
    return ok(pageMapper.toPageDto(pageService.savePage(page)));
  }

  @Override
  @DeleteMapping("/{id}")
  public void deletePage(@PathVariable(value = "id") Long id) {
    pageService.deletePage(id);
  }

}
