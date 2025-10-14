package com.nyxelis.service;

import com.nyxelis.dto.DtoPage;

public interface IPageService {
  DtoPage pageFindById(Long id);

  DtoPage pageFindBySlug(String slug);

  DtoPage createPage(DtoPage dtoPage);

  DtoPage updatePage(Long id, DtoPage dtoPage);

  void deletePage(Long id);
}
