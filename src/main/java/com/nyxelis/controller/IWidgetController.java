package com.nyxelis.controller;

import com.nyxelis.dto.DtoWidget;
import com.nyxelis.dto.DtoWidgetIU;
import com.nyxelis.entity.RootEntityResponse;

public interface IWidgetController {
  RootEntityResponse<DtoWidget> getWidgetById(Long id);

  RootEntityResponse<DtoWidgetIU> createWidget(DtoWidgetIU widgetData);

  RootEntityResponse<DtoWidgetIU> updateWidget(Long id, DtoWidgetIU widgetData);

  void deleteWidget(Long id);
}
