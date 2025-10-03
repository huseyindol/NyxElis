package com.nyxelis.mapper;

import com.nyxelis.dto.DtoPageComponent;
import com.nyxelis.entity.PageComponent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ComponentMapper.class })
public interface PageComponentMapper {
    @Mapping(source = "page.id", target = "pageId")
    @Mapping(source = "component.id", target = "componentId")
    DtoPageComponent toPageComponentDto(PageComponent pageComponent);

    List<DtoPageComponent> toPageComponentDtoList(List<PageComponent> pageComponents);
}
