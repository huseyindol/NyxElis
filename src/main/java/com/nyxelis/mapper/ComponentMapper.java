package com.nyxelis.mapper;

import com.nyxelis.dto.DtoComponent;
import com.nyxelis.entity.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = { BannerMapper.class })
public interface ComponentMapper {
    @Mapping(source = "componentBanners", target = "banners")
    DtoComponent toComponentDto(Component component);

    Component toComponentEntity(DtoComponent dtoComponent);

    void updateComponentEntityFromDto(DtoComponent dtoComponent, @MappingTarget Component component);

    List<DtoComponent> toComponentDtoList(List<Component> components);
}
