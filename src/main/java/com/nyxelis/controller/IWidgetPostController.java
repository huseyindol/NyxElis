package com.nyxelis.controller;

import com.nyxelis.dto.DtoWidgetPost;
import com.nyxelis.dto.DtoWidgetPostIU;

import java.util.List;

public interface IWidgetPostController {
  List<DtoWidgetPost> getWidgetsOfPost(Long postId);

  DtoWidgetPostIU addWidgetPost(DtoWidgetPostIU widgetPostData);

  DtoWidgetPost reorderWidgetPost(List<DtoWidgetPostIU> widgetPostIUList);
}
