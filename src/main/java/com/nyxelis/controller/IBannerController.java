package com.nyxelis.controller;

import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;
import com.nyxelis.entity.RootEntityResponse;

public interface IBannerController {
    public RootEntityResponse<DtoBanner> getBannerById(Long id);

    public RootEntityResponse<DtoBannerIU> createBanner(DtoBannerIU dtoBanner);

    public RootEntityResponse<DtoBannerIU> updateBanner(Long id, DtoBannerIU dtoBanner);

    public void deleteBanner(Long id);
}
