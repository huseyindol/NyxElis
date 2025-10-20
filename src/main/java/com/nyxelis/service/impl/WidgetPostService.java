package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoWidgetPost;
import com.nyxelis.dto.DtoWidgetPostIU;
import com.nyxelis.entity.Post;
import com.nyxelis.entity.Widget;
import com.nyxelis.entity.WidgetPost;
import com.nyxelis.entity.id.WidgetPostId;
import com.nyxelis.mapper.WidgetPostMapper;
import com.nyxelis.repository.PostRepository;
import com.nyxelis.repository.WidgetPostRepository;
import com.nyxelis.repository.WidgetRepository;
import com.nyxelis.service.IWidgetPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetPostService implements IWidgetPostService {
  @Autowired
  private WidgetPostRepository widgetPostRepository;
  @Autowired
  private WidgetRepository widgetRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private WidgetPostMapper widgetPostMapper;

  @Override
  public List<DtoWidgetPost> getWidgetPostByWidgetId(Long widgetId) {
    List<WidgetPost> widgetPosts = widgetPostRepository.findByWidgetId(widgetId);
    return widgetPostMapper.toWidgetPostDtoList(widgetPosts);
  }

  @Override
  public DtoWidgetPostIU addWidgetPost(DtoWidgetPostIU widgetPostData) {
    Widget widget = widgetRepository.findById(widgetPostData.getWidgetId()).orElseThrow(() -> new IllegalArgumentException("Widget not found"));
    Post post = postRepository.findById(widgetPostData.getPostId()).orElseThrow(() -> new IllegalArgumentException("Post not found"));

    WidgetPost widgetPost = new WidgetPost();
    widgetPost.setWidget(widget);
    widgetPost.setPost(post);
    widgetPost.setOrderIndex(widgetPostData.getOrderIndex());

    WidgetPostId id = new WidgetPostId(widgetPostData.getWidgetId(), widgetPostData.getPostId());
    widgetPost.setId(id);

    WidgetPost savedWidgetPost = widgetPostRepository.save(widgetPost);
    return widgetPostMapper.toWidgetPostIUDto(savedWidgetPost);
  }
}
