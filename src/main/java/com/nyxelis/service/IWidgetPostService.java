package com.nyxelis.service;

import com.nyxelis.entity.WidgetPost;

import java.util.List;

public interface IWidgetPostService {
  List<WidgetPost> getWidgetPostByWidgetId(Long postId);

  WidgetPost addWidgetPost(WidgetPost widgetPost);
}
