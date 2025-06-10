package com.nyxelis.mapper;

import com.nyxelis.dto.DtoPageComponent;
import com.nyxelis.entity.PageComponent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageComponentMapper {
    PageComponentMapper INSTANCE = Mappers.getMapper(PageComponentMapper.class);

    @Mapping(source = "page.id", target = "pageId")
    @Mapping(source = "component.id", target = "componentId")
    DtoPageComponent toPageComponentDto(PageComponent pageComponent);

    PageComponent toPageComponentEntity(DtoPageComponent dtoPageComponent);

    List<DtoPageComponent> toPageComponentDtoList(List<PageComponent> pageComponents);
}
