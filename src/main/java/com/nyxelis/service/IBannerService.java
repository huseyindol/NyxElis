package com.nyxelis.service;

import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;

public interface IBannerService {
    public DtoBanner getBannerById(Long id);

    public DtoBannerIU createBanner(DtoBannerIU dtoBanner);

    public DtoBannerIU updateBanner(Long id, DtoBannerIU dtoBanner);

    public void deleteBanner(Long id);
}
