package com.nyxelis.controller;

import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;
import com.nyxelis.entity.RootEntityResponse;

public interface IBannerController {
  RootEntityResponse<DtoBanner> getBannerById(Long id);

  RootEntityResponse<DtoBannerIU> createBanner(DtoBannerIU dtoBanner);

  RootEntityResponse<DtoBannerIU> updateBanner(Long id, DtoBannerIU dtoBanner);

  void deleteBanner(Long id);
}
