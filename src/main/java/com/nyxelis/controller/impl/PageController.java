package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPageController;
import com.nyxelis.dto.DtoPageIU;
import com.nyxelis.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/page")
public class PageController implements IPageController {

    @Autowired
    private IPageService pageService;

    @GetMapping("/{id}")
    @Override
    public DtoPageIU pageFindById(@PathVariable(value = "id") Long id) {
        return pageService.pageFindById(id);
    }

    @PostMapping("/create")
    @Override
    public DtoPageIU createPage(@RequestBody DtoPageIU dtoPageIU) {
        return pageService.createPage(dtoPageIU);
    }

    @PostMapping("/update/{id}")
    @Override
    public DtoPageIU updatePage(@PathVariable(value = "id") Long id, @RequestBody DtoPageIU dtoPageIU) {
        return pageService.updatePage(id, dtoPageIU);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deletePage(@PathVariable(value = "id") Long id) {
        pageService.deletePage(id);
    }

}
