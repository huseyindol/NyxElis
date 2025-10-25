package com.nyxelis.mapper;

import com.nyxelis.dto.DtoWidgetPost;
import com.nyxelis.dto.DtoWidgetPostIU;
import com.nyxelis.entity.WidgetPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WidgetMapper.class, PostMapper.class})
public interface WidgetPostMapper {
  @Mapping(source = "widget.id", target = "widgetId")
  @Mapping(source = "post.id", target = "postId")
  DtoWidgetPostIU toWidgetPostIUDto(WidgetPost widgetPost);

  @Mapping(source = "widget.id", target = "widgetId")
  @Mapping(source = "post.id", target = "postId")
  @Mapping(source = "widget", target = "widgets")
  @Mapping(source = "post", target = "posts")
  DtoWidgetPost toWidgetPostDto(WidgetPost widgetPost);

  @Mapping(source = "widget.id", target = "widgtId")
  @Mapping(source = "post.id", target = "postId")
  @Mapping(source = "widget", target = "widgets")
  @Mapping(source = "post", target = "posts")
  List<DtoWidgetPost> toWidgetPostDtoList(List<WidgetPost> widgetPosts);

}
