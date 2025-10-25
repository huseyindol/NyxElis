package com.nyxelis.service;

import com.nyxelis.entity.Post;

public interface IPostService {
  Post postFindById(Long id);

  Post postFindBySlug(String slug);

  Post savePost(Post post);

  void deletePost(Long id);
}
