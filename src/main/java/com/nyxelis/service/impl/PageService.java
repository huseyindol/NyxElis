package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoPage;
import com.nyxelis.entity.Page;
import com.nyxelis.mapper.PageMapper;
import com.nyxelis.repository.PageRepository;
import com.nyxelis.service.IPageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService implements IPageService {

  @Autowired
  private PageRepository pageRepository;

  @Autowired
  private PageMapper pageMapper;

  @Override
  public DtoPage pageFindById(Long id) {
    Page pageDB = pageRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));
    return pageMapper.toPageDto(pageDB);
  }

  @Override
  public DtoPage createPage(DtoPage dtoPage) {
    Page pageEntity = pageMapper.toPageEntity(dtoPage);
    Page saved = pageRepository.save(pageEntity);
    return pageMapper.toPageDto(saved);
  }

  @Override
  public DtoPage updatePage(Long id, DtoPage dtoPage) {
    Page page = pageRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));
    // DTO'dan gelen alanları var olan entity üzerine uygula
    pageMapper.updatePageEntityFromDto(dtoPage, page);
    // updatedAt otomatik setlenebilir, gerekiyorsa burada da el ile yazılabilir
    Page updatedPage = pageRepository.save(page);
    return pageMapper.toPageDto(updatedPage);
  }

  @Override
  public void deletePage(Long id) {
    Page pageDB = pageRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));
    pageRepository.delete(pageDB);
  }

  @Override
  public DtoPage pageFindBySlug(String slug) {
    Page pageDB = pageRepository.findBySlug(slug)
      .orElseThrow(() -> new EntityNotFoundException("Page not found with slug: " + slug));
    return pageMapper.toPageDto(pageDB);
  }
}
