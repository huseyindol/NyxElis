package com.nyxelis.service;

import com.nyxelis.dto.DtoWidgetPost;
import com.nyxelis.dto.DtoWidgetPostIU;

import java.util.List;

public interface IWidgetPostService {
  List<DtoWidgetPost> getWidgetPostByWidgetId(Long postId);

  DtoWidgetPostIU addWidgetPost(DtoWidgetPostIU widgetPostData);
}
