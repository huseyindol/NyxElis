package com.nyxelis.mapper;

import com.nyxelis.dto.DtoWidget;
import com.nyxelis.dto.DtoWidgetIU;
import com.nyxelis.entity.Widget;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WidgetMapper {
  DtoWidget toWidgetDto(Widget widget);

  DtoWidgetIU toWidgetIUDto(Widget widget);

  Widget toWidgetEntity(DtoWidgetIU dtoWidgetIU);

  void updateWidgetEntityFromDto(DtoWidgetIU dtoWidget, @MappingTarget Widget widget);
}
