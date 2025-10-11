package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;
import com.nyxelis.entity.Banner;
import com.nyxelis.mapper.BannerMapper;
import com.nyxelis.repository.BannerRepository;
import com.nyxelis.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService implements IBannerService {
    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public DtoBanner getBannerById(Long id) {
        Banner banner = bannerRepository.findById(id).orElseThrow(() -> new RuntimeException("Banner not found"));
        return bannerMapper.toBannerDto(banner);
    }

    @Override
    public DtoBannerIU createBanner(DtoBannerIU dtoBanner) {
        Banner banner = bannerMapper.toBannerEntity(dtoBanner);
        Banner saved = bannerRepository.save(banner);
        return bannerMapper.toBannerUIDto(saved);
    }

    @Override
    public DtoBannerIU updateBanner(Long id, DtoBannerIU dtoBanner) {
        Banner banner = bannerRepository.findById(id).orElseThrow(() -> new RuntimeException("Banner not found"));
        bannerMapper.updateBannerEntityFromDto(dtoBanner, banner);
        Banner updated = bannerRepository.save(banner);
        return bannerMapper.toBannerUIDto(updated);
    }

    @Override
    public void deleteBanner(Long id) {
        Banner banner = bannerRepository.findById(id).orElseThrow(() -> new RuntimeException("Banner not found"));
        bannerRepository.delete(banner);
    }
}
