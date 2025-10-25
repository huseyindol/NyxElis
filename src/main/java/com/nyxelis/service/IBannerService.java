package com.nyxelis.service;

import com.nyxelis.entity.Banner;

public interface IBannerService {
  Banner getBannerById(Long id);

  Banner saveBanner(Banner banner);

  void deleteBanner(Long id);
}
