package com.nyxelis.controller;

import com.nyxelis.dto.DtoPage;
import com.nyxelis.entity.RootEntityResponse;

public interface IPageController {

    public RootEntityResponse<DtoPage> pageFindBySlug(String slug);

    public RootEntityResponse<DtoPage> createPage(DtoPage dtoPage);

    public RootEntityResponse<DtoPage> updatePage(Long id, DtoPage dtoPage);

    public void deletePage(Long id);
}
