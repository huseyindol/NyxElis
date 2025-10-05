package com.nyxelis.controller;

import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;
import com.nyxelis.entity.RootEntityResponse;

public interface IPostController {
    RootEntityResponse<DtoPost> postFindBySlug(String slug);

    RootEntityResponse<DtoPost> createPost(DtoPostIU dtoPost);

    RootEntityResponse<DtoPost> updatePost(Long id, DtoPostIU dtoPost);

    void deletePost(Long id);
}
