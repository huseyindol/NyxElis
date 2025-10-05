package com.nyxelis.controller;

import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;
import com.nyxelis.entity.RootEntityResponse;

public interface IPostController {
    public RootEntityResponse<DtoPost> postFindBySlug(String slug);
    public RootEntityResponse<DtoPost> createPost(DtoPostIU dtoPost);
    public RootEntityResponse<DtoPost> updatePost(Long id, DtoPostIU dtoPost);
    public void deletePost(Long id);
}
