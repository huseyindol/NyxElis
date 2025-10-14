package com.nyxelis.service;

import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;

public interface IBannerService {
  DtoBanner getBannerById(Long id);

  DtoBannerIU createBanner(DtoBannerIU dtoBanner);

  DtoBannerIU updateBanner(Long id, DtoBannerIU dtoBanner);

  void deleteBanner(Long id);
}
