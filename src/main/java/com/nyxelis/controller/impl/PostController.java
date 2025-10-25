package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPostController;
import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;
import com.nyxelis.entity.Customer;
import com.nyxelis.entity.Post;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.mapper.PostMapper;
import com.nyxelis.service.ICustomerService;
import com.nyxelis.service.IPostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@Tag(name = "Post Services")
public class PostController extends BaseController implements IPostController {
  @Autowired
  private IPostService postService;
  @Autowired
  private ICustomerService customerService;
  @Autowired
  private PostMapper postMapper;

  @Override
  @GetMapping("/byId/{id}")
  public RootEntityResponse<DtoPost> postFindById(@PathVariable(value = "id") Long id) {
    return ok(postMapper.toPostDto(postService.postFindById(id)));
  }

  @Override
  @GetMapping("/{slug}")
  public RootEntityResponse<DtoPost> postFindBySlug(@PathVariable(value = "slug") String slug) {
    return ok(postMapper.toPostDto(postService.postFindBySlug(slug)));
  }

  @Override
  @PostMapping("/create")
  public RootEntityResponse<DtoPost> createPost(@RequestBody DtoPostIU dtoPost) {
    Post postEntity = postMapper.toPostIUEntity(dtoPost);
    Customer author = customerService.findById(dtoPost.getAuthorId());
    if (author == null) {
      throw new RuntimeException("Author not found with id: " + dtoPost.getAuthorId());
    }
    postEntity.setAuthor(author);
    return ok(postMapper.toPostDto(postService.savePost(postEntity)));
  }

  @Override
  @PutMapping("/{id}")
  public RootEntityResponse<DtoPost> updatePost(@PathVariable(value = "id") Long id, @RequestBody DtoPostIU dtoPost) {
    Post post = postService.postFindById(id);
    postMapper.updatePostEntityFromDto(dtoPost, post);
    return ok(postMapper.toPostDto(postService.savePost(post)));
  }

  @Override
  @DeleteMapping("/{id}")
  public void deletePost(Long id) {
    postService.deletePost(id);
  }
}
