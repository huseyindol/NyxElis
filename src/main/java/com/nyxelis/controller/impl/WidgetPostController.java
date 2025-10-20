package com.nyxelis.controller.impl;

import com.nyxelis.controller.IWidgetPostController;
import com.nyxelis.dto.DtoWidgetPost;
import com.nyxelis.dto.DtoWidgetPostIU;
import com.nyxelis.service.IWidgetPostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/widget-posts")
@Tag(name = "Widget Post Controller")
public class WidgetPostController implements IWidgetPostController {
  @Autowired
  private IWidgetPostService widgetPostService;

  @Override
  @GetMapping("/{widgetId}")
  public List<DtoWidgetPost> getWidgetsOfPost(@PathVariable(name = "widgetId") Long id) {
    return widgetPostService.getWidgetPostByWidgetId(id);
  }

  @Override
  @PostMapping("/add")
  public DtoWidgetPostIU addWidgetPost(@RequestBody DtoWidgetPostIU widgetPostData) {
    DtoWidgetPostIU dtoWidgetPostIU = widgetPostService.addWidgetPost(widgetPostData);
    return dtoWidgetPostIU;
  }

  @Override
  public DtoWidgetPost reorderWidgetPost(List<DtoWidgetPostIU> widgetPostIUList) {
    return null;
  }


}
