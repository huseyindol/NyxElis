package com.nyxelis.mapper;

import com.nyxelis.dto.DtoComponent;
import com.nyxelis.entity.Component;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ComponentMapper {
    ComponentMapper INSTANCE = Mappers.getMapper(ComponentMapper.class);

    DtoComponent toComponentDto(Component component);

    Component toComponentEntity(DtoComponent dtoComponent);

    void updateComponentEntityFromDto(DtoComponent dtoComponent, @MappingTarget Component component);

    List<DtoComponent> toComponentDtoList(List<Component> components);
}
