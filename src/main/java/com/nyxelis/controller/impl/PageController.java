package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPageController;
import com.nyxelis.dto.DtoPage;
import com.nyxelis.service.IPageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/page")
@Tag(name = "Page Services")
public class PageController implements IPageController {

    @Autowired
    private IPageService pageService;

    @GetMapping("/{slug}")
    @Override
    public DtoPage pageFindBySlug(@PathVariable(value = "slug") String slug) {
        return pageService.pageFindBySlug(slug);
    }

    @PostMapping("/create")
    @Override
    public DtoPage createPage(@RequestBody DtoPage dtoPage) {
        return pageService.createPage(dtoPage);
    }

    @PostMapping("/update/{id}")
    @Override
    public DtoPage updatePage(@PathVariable(value = "id") Long id, @RequestBody DtoPage dtoPage) {
        return pageService.updatePage(id, dtoPage);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deletePage(@PathVariable(value = "id") Long id) {
        pageService.deletePage(id);
    }

}
