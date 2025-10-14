package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoWidget;
import com.nyxelis.dto.DtoWidgetIU;
import com.nyxelis.entity.Widget;
import com.nyxelis.mapper.WidgetMapper;
import com.nyxelis.repository.WidgetRepository;
import com.nyxelis.service.IWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService implements IWidgetService {
  @Autowired
  private WidgetRepository widgetRepository;
  @Autowired
  private WidgetMapper widgetMapper;

  @Override
  public DtoWidget getWidgetById(Long id) {
    Widget widgetDB = widgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Widget not found with id: " + id));
    return widgetMapper.toWidgetDto(widgetDB);
  }

  @Override
  public DtoWidgetIU createWidget(DtoWidgetIU widgetData) {
    Widget widgetIUEntity = widgetMapper.toWidgetIUEntity(widgetData);
    Widget saved = widgetRepository.save(widgetIUEntity);
    return widgetMapper.toWidgetIUDto(saved);
  }

  @Override
  public DtoWidgetIU updateWidget(Long id, DtoWidgetIU widgetData) {
    Widget widget =
      widgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Widget not found with id: " + id));
    // DTO'dan gelen alanları var olan entity üzerine uygula
    widgetMapper.updateWidgetEntityFromDto(widgetData, widget);
    Widget updatedWidget = widgetRepository.save(widget);
    return widgetMapper.toWidgetIUDto(updatedWidget);
  }

  @Override
  public void deleteWidget(Long id) {
    widgetRepository.deleteById(id);
  }
}
