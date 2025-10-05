package com.nyxelis.service;

import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;

public interface IPostService {
    DtoPost postFindById(Long id);

    DtoPost postFindBySlug(String slug);

    DtoPost createPost(DtoPostIU dtoPost);

    DtoPost updatePost(Long id, DtoPostIU dtoPost);

    void deletePost(Long id);
}
