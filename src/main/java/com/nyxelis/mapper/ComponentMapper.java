package com.nyxelis.mapper;

import com.nyxelis.dto.DtoComponentIU;
import com.nyxelis.entity.Component;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ComponentMapper {
    ComponentMapper INSTANCE = Mappers.getMapper(ComponentMapper.class);

    DtoComponentIU toDtoIU(Component component);

    Component toEntityIU(DtoComponentIU dtoComponentIU);

    void updateEntityFromDto(DtoComponentIU dtoComponentIU, @MappingTarget Component component);

    List<DtoComponentIU> toDtoIUList(List<Component> components);
}
