package com.nyxelis.service.impl;

import com.nyxelis.entity.Banner;
import com.nyxelis.repository.BannerRepository;
import com.nyxelis.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService implements IBannerService {
  @Autowired
  private BannerRepository bannerRepository;

  @Override
  public Banner getBannerById(Long id) {
    return bannerRepository.findById(id).orElseThrow(() -> new RuntimeException("Banner not found"));
  }

  @Override
  public Banner saveBanner(Banner banner) {
    return bannerRepository.save(banner);
  }

  @Override
  public void deleteBanner(Long id) {
    Banner banner = bannerRepository.findById(id).orElseThrow(() -> new RuntimeException("Banner not found"));
    bannerRepository.delete(banner);
  }
}
