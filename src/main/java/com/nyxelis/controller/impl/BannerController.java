package com.nyxelis.controller.impl;

import com.nyxelis.controller.IBannerController;
import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;
import com.nyxelis.entity.Banner;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.mapper.BannerMapper;
import com.nyxelis.service.impl.BannerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banners")
@Tag(name = "Banner Services")
public class BannerController extends BaseController implements IBannerController {
  @Autowired
  private BannerService bannerService;

  @Autowired
  private BannerMapper bannerMapper;

  @Override
  @GetMapping("/{id}")
  public RootEntityResponse<DtoBanner> getBannerById(@PathVariable(value = "id") Long id) {
    Banner banner = bannerService.getBannerById(id);
    return ok(bannerMapper.toBannerDto(banner));
  }

  @Override
  @PostMapping("/create")
  public RootEntityResponse<DtoBannerIU> createBanner(@RequestBody DtoBannerIU dtoBanner) {
    Banner banner = bannerMapper.toBannerEntity(dtoBanner);
    return ok(bannerMapper.toBannerUIDto(bannerService.saveBanner(banner)));
  }

  @Override
  @PutMapping("/{id}")
  public RootEntityResponse<DtoBannerIU> updateBanner(@PathVariable(value = "id") Long id,
                                                      @RequestBody DtoBannerIU dtoBanner) {
    Banner banner = bannerService.getBannerById(id);
    bannerMapper.updateBannerEntityFromDto(dtoBanner, banner);
    return RootEntityResponse.ok(bannerMapper.toBannerUIDto(bannerService.saveBanner(banner)));
  }

  @Override
  @DeleteMapping("/{id}")
  public void deleteBanner(@PathVariable(value = "id") Long id) {
    bannerService.deleteBanner(id);
  }
}
