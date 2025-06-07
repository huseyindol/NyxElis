package com.nyxelis.mapper;

import com.nyxelis.dto.DtoSeoInfo;
import com.nyxelis.entity.SeoInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface SeoInfoMapper {
    SeoInfoMapper INSTANCE = Mappers.getMapper(SeoInfoMapper.class);

    DtoSeoInfo toDto(SeoInfo seoInfo);

    SeoInfo toEntity(DtoSeoInfo dtoSeoInfo);

}
