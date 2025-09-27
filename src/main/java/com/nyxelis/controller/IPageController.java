package com.nyxelis.controller;

import com.nyxelis.dto.DtoPage;

public interface IPageController {

    public DtoPage pageFindBySlug(String slug);

    public DtoPage createPage(DtoPage dtoPage);

    public DtoPage updatePage(Long id, DtoPage dtoPage);

    public void deletePage(Long id);
}
