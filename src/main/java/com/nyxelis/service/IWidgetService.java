package com.nyxelis.service;

import com.nyxelis.dto.DtoWidget;
import com.nyxelis.dto.DtoWidgetIU;

public interface IWidgetService {
  DtoWidget getWidgetById(Long id);

  DtoWidgetIU createWidget(DtoWidgetIU widgetData);

  DtoWidgetIU updateWidget(Long id, DtoWidgetIU widgetData);

  void deleteWidget(Long id);
}
