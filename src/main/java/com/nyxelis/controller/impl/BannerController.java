package com.nyxelis.controller.impl;

import com.nyxelis.controller.IBannerController;
import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.service.impl.BannerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banners")
@Tag(name = "Banner Services")
public class BannerController implements IBannerController {
  @Autowired
  private BannerService bannerService;

  @Override
  @GetMapping("/{id}")
  public RootEntityResponse<DtoBanner> getBannerById(@PathVariable(value = "id") Long id) {
    return RootEntityResponse.ok(bannerService.getBannerById(id));
  }

  @Override
  @PostMapping("/create")
  public RootEntityResponse<DtoBannerIU> createBanner(@RequestBody DtoBannerIU dtoBanner) {
    return RootEntityResponse.ok(bannerService.createBanner(dtoBanner));
  }

  @Override
  @PutMapping("/{id}")
  public RootEntityResponse<DtoBannerIU> updateBanner(@PathVariable(value = "id") Long id,
                                                      @RequestBody DtoBannerIU dtoBanner) {
    return RootEntityResponse.ok(bannerService.updateBanner(id, dtoBanner));
  }

  @Override
  @DeleteMapping("/{id}")
  public void deleteBanner(@PathVariable(value = "id") Long id) {
    bannerService.deleteBanner(id);
  }
}
