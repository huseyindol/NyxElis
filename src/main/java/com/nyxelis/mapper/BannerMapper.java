package com.nyxelis.mapper;

import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoBannerIU;
import com.nyxelis.entity.Banner;
import com.nyxelis.entity.ComponentBanner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BannerMapper {
  @Mapping(source = "banner.id", target = "id")
  @Mapping(source = "banner.title", target = "title")
  @Mapping(source = "banner.description", target = "description")
  @Mapping(source = "banner.imageUrl", target = "imageUrl")
  @Mapping(source = "banner.link", target = "link")
  @Mapping(source = "banner.altText", target = "altText")
  @Mapping(source = "banner.isActive", target = "isActive")
  @Mapping(source = "banner.orderDisplay", target = "orderDisplay")
  @Mapping(source = "orderIndex", target = "orderIndex")
  DtoBanner componentBannerToBannerDto(ComponentBanner componentBanner);

  DtoBanner toBannerDto(Banner banner);

  DtoBannerIU toBannerUIDto(Banner banner);

  Banner toBannerEntity(DtoBannerIU dtoBanner);

  void updateBannerEntityFromDto(DtoBannerIU dtoBanner, @MappingTarget Banner banner);

  List<DtoBanner> componentBannersToBannerDtos(List<ComponentBanner> componentBanners);
}
