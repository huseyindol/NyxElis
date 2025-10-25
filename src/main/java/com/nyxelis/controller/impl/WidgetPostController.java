package com.nyxelis.controller.impl;

import com.nyxelis.controller.IWidgetPostController;
import com.nyxelis.dto.DtoWidgetPost;
import com.nyxelis.dto.DtoWidgetPostIU;
import com.nyxelis.entity.Post;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.entity.Widget;
import com.nyxelis.entity.WidgetPost;
import com.nyxelis.entity.id.WidgetPostId;
import com.nyxelis.mapper.WidgetPostMapper;
import com.nyxelis.service.IPostService;
import com.nyxelis.service.IWidgetPostService;
import com.nyxelis.service.IWidgetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nyxelis.entity.RootEntityResponse.ok;

@RestController
@RequestMapping("/api/widget-posts")
@Tag(name = "Widget Post Controller")
public class WidgetPostController implements IWidgetPostController {
  @Autowired
  private IWidgetPostService widgetPostService;
  @Autowired
  private IWidgetService widgetService;
  @Autowired
  private IPostService postService;
  @Autowired
  private WidgetPostMapper widgetPostMapper;

  @Override
  @GetMapping("/{widgetId}")
  public RootEntityResponse<List<DtoWidgetPost>> getWidgetsOfPost(@PathVariable(name = "widgetId") Long id) {
    return ok(widgetPostMapper.toWidgetPostDtoList(widgetPostService.getWidgetPostByWidgetId(id)));
  }

  @Override
  @PostMapping("/add")
  public DtoWidgetPostIU addWidgetPost(@RequestBody DtoWidgetPostIU widgetPostData) {
    Widget widget = widgetService.getWidgetById(widgetPostData.getWidgetId());
    Post post = postService.postFindById(widgetPostData.getPostId());
    WidgetPost widgetPost = new WidgetPost();
    widgetPost.setWidget(widget);
    widgetPost.setPost(post);
    widgetPost.setOrderIndex(widgetPostData.getOrderIndex());

    WidgetPostId id = new WidgetPostId(widgetPostData.getWidgetId(), widgetPostData.getPostId());
    widgetPost.setId(id);

    return widgetPostMapper.toWidgetPostIUDto(widgetPostService.addWidgetPost(widgetPost));
  }

  @Override
  public DtoWidgetPost reorderWidgetPost(List<DtoWidgetPostIU> widgetPostIUList) {
    return null;
  }


}
