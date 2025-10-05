package com.nyxelis.service;

import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;

public interface IPostService {
    public DtoPost postFindById(Long id);

    public DtoPost postFindBySlug(String slug);

    public DtoPost createPost(DtoPostIU dtoPost);

    public DtoPost updatePost(Long id, DtoPostIU dtoPost);

    public void deletePost(Long id);
}
