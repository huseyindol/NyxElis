package com.nyxelis.service.impl;

import com.nyxelis.entity.WidgetPost;
import com.nyxelis.repository.WidgetPostRepository;
import com.nyxelis.service.IWidgetPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetPostService implements IWidgetPostService {
  @Autowired
  private WidgetPostRepository widgetPostRepository;

  @Override
  public List<WidgetPost> getWidgetPostByWidgetId(Long widgetId) {
    return widgetPostRepository.findByWidgetId(widgetId);
  }

  @Override
  public WidgetPost addWidgetPost(WidgetPost widgetPost) {
    return widgetPostRepository.save(widgetPost);
  }
}
