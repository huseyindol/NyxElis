package com.nyxelis.mapper;

import com.nyxelis.dto.DtoBanner;
import com.nyxelis.entity.ComponentBanner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
    @Mapping(source = "orderIndex", target = "orderIndex")
    DtoBanner componentBannerToBannerDto(ComponentBanner componentBanner);

    List<DtoBanner> componentBannersToBannerDtos(List<ComponentBanner> componentBanners);
}
