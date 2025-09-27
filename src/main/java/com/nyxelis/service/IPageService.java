package com.nyxelis.service;

import com.nyxelis.dto.DtoPage;

public interface IPageService {
    public DtoPage pageFindById(Long id);

    public DtoPage pageFindBySlug(String slug);

    public DtoPage createPage(DtoPage dtoPage);

    public DtoPage updatePage(Long id, DtoPage dtoPage);

    public void deletePage(Long id);
}
