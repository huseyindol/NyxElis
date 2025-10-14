package com.nyxelis.mapper;

import com.nyxelis.dto.DtoPage;
import com.nyxelis.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PageComponentMapper.class})
public interface PageMapper {
  @Mapping(source = "pageComponents", target = "pageComponents")
  DtoPage toPageDto(Page page);

  Page toPageEntity(DtoPage dtoPage);

  void updatePageEntityFromDto(DtoPage dtoPage, @MappingTarget Page page);
}
