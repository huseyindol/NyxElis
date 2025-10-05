package com.nyxelis.controller.impl;

import com.nyxelis.controller.IPostController;
import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;
import com.nyxelis.entity.RootEntityResponse;
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

    @Override
    @GetMapping("/{id}")
    public RootEntityResponse<DtoPost> postFindById(@PathVariable(value = "id") Long id) {
        return ok(postService.postFindById(id));
    }

    @Override
    @GetMapping("/{slug}")
    public RootEntityResponse<DtoPost> postFindBySlug(@PathVariable(value = "slug") String slug) {
        return ok(postService.postFindBySlug(slug));
    }

    @Override
    @PostMapping("/create")
    public RootEntityResponse<DtoPost> createPost(DtoPostIU dtoPost) {
        return ok(postService.createPost(dtoPost));
    }

    @Override
    @PostMapping("/update/{id}")
    public RootEntityResponse<DtoPost> updatePost(@PathVariable(value = "id") Long id, DtoPostIU dtoPost) {
        return ok(postService.updatePost(id, dtoPost));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deletePost(Long id) {
        postService.deletePost(id);
    }
}
