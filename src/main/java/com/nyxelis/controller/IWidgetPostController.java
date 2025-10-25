package com.nyxelis.controller;

import com.nyxelis.dto.DtoWidgetPost;
import com.nyxelis.dto.DtoWidgetPostIU;
import com.nyxelis.entity.RootEntityResponse;

import java.util.List;

public interface IWidgetPostController {
  RootEntityResponse<List<DtoWidgetPost>> getWidgetsOfPost(Long postId);

  DtoWidgetPostIU addWidgetPost(DtoWidgetPostIU widgetPostData);

  DtoWidgetPost reorderWidgetPost(List<DtoWidgetPostIU> widgetPostIUList);
}
