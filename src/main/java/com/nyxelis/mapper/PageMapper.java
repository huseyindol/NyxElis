package com.nyxelis.mapper;

import com.nyxelis.dto.DtoPage;
import com.nyxelis.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageMapper{
    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);

    DtoPage toPageDto(Page page);
    Page toPageEntity(DtoPage dtoPage);

    void updatePageEntityFromDto(DtoPage dtoPage, @MappingTarget Page page);
}
