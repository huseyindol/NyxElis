package com.nyxelis.service;

import com.nyxelis.entity.Page;

public interface IPageService {
  Page pageFindById(Long id);

  Page pageFindBySlug(String slug);

  Page savePage(Page page);

  void deletePage(Long id);
}
