package com.nyxelis.controller;

import com.nyxelis.dto.DtoPage;
import com.nyxelis.entity.RootEntityResponse;

public interface IPageController {
  RootEntityResponse<DtoPage> pageFindBySlug(String slug);

  RootEntityResponse<DtoPage> createPage(DtoPage dtoPage);

  RootEntityResponse<DtoPage> updatePage(Long id, DtoPage dtoPage);

  void deletePage(Long id);
}
