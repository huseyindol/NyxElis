package com.nyxelis.mapper;

import com.nyxelis.dto.DtoPageIU;
import com.nyxelis.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageMapper{
    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);

    DtoPageIU toDtoIU(Page page);
    Page toEntityIU(DtoPageIU dtoPageIU);

    void updateEntityFromDto(DtoPageIU dtoPageIU, @MappingTarget Page page);
}
