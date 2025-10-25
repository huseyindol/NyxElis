package com.nyxelis.service;

import com.nyxelis.entity.Widget;

public interface IWidgetService {
  Widget getWidgetById(Long id);

  Widget saveWidget(Widget widget);

  void deleteWidget(Long id);
}
