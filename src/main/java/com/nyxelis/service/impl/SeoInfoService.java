package com.nyxelis.service.impl;

import com.nyxelis.entity.SeoInfo;
import com.nyxelis.repository.SeoInfoRepository;
import com.nyxelis.service.ISeoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeoInfoService implements ISeoInfoService {

    @Autowired
    private SeoInfoRepository seoInfoRepository;


    @Override
    public SeoInfo createSeoInfo(SeoInfo seoInfo) {
        SeoInfo saved = seoInfoRepository.save(seoInfo);
        if (saved == null) {
            throw new RuntimeException("Failed to create SEO info");
        }
        return saved;
    }
}
