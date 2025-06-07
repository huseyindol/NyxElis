package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoPageIU;
import com.nyxelis.dto.DtoSeoInfo;
import com.nyxelis.entity.Page;
import com.nyxelis.entity.SeoInfo;
import com.nyxelis.mapper.PageMapper;
import com.nyxelis.mapper.SeoInfoMapper;
import com.nyxelis.repository.PageRepository;
import com.nyxelis.repository.SeoInfoRepository;
import com.nyxelis.service.IPageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PageService implements IPageService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private SeoInfoRepository seoInfoRepository;

    @Override
    public DtoPageIU pageFindById(Long id) {
        Page pageDB = pageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));
        return PageMapper.INSTANCE.toDtoIU(pageDB);
    }

    @Override
    public DtoPageIU createPage(DtoPageIU dtoPageIU) {
        Page pageEntity = PageMapper.INSTANCE.toEntityIU(dtoPageIU);
        Page saved = pageRepository.save(pageEntity);
        return PageMapper.INSTANCE.toDtoIU(saved);
    }

    @Override
    public DtoPageIU updatePage(Long id, DtoPageIU dtoPageIU) {
        Page page = pageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Page not found with id: " + id));
        // DTO'dan gelen alanları var olan entity üzerine uygula
        PageMapper.INSTANCE.updateEntityFromDto(dtoPageIU, page);
        // updatedAt otomatik setlenebilir, gerekiyorsa burada da el ile yazılabilir
        Page updatedPage = pageRepository.save(page);
        return PageMapper.INSTANCE.toDtoIU(updatedPage);
    }
}
