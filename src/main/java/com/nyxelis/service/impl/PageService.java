package com.nyxelis.service.impl;

import com.nyxelis.entity.Page;
import com.nyxelis.repository.PageRepository;
import com.nyxelis.service.IPageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService implements IPageService {

  @Autowired
  private PageRepository pageRepository;

  @Override
  public Page pageFindById(Long id) {
    return pageRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));
  }

  @Override
  public Page savePage(Page page) {
    return pageRepository.save(page);
  }

  @Override
  public void deletePage(Long id) {
    Page pageDB = pageRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));
    pageRepository.delete(pageDB);
  }

  @Override
  public Page pageFindBySlug(String slug) {
    return pageRepository.findBySlug(slug)
      .orElseThrow(() -> new EntityNotFoundException("Page not found with slug: " + slug));
  }
}
