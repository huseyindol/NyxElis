package com.nyxelis.service.impl;

import com.nyxelis.entity.Widget;
import com.nyxelis.repository.WidgetRepository;
import com.nyxelis.service.IWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService implements IWidgetService {
  @Autowired
  private WidgetRepository widgetRepository;

  @Override
  public Widget getWidgetById(Long id) {
    return widgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Widget not found with id: " + id));
  }

  @Override
  public Widget saveWidget(Widget widget) {
    return widgetRepository.save(widget);
  }

  @Override
  public void deleteWidget(Long id) {
    widgetRepository.deleteById(id);
  }
}
