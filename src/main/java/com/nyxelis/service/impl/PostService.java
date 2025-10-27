package com.nyxelis.service.impl;

import com.nyxelis.entity.Post;
import com.nyxelis.repository.PostRepository;
import com.nyxelis.service.IPostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
  @Autowired
  private PostRepository postRepository;

  @Override
  public Post postFindById(Long id) {
    return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
  }

  @Override
  public Post postFindBySlug(String slug) {
    return postRepository.findBySlug(slug)
      .orElseThrow(() -> new EntityNotFoundException("Post not found with slug: " + slug));
  }

  @Override
  public Post savePost(Post post) {
    return postRepository.save(post);
  }

  @Override
  public void deletePost(Long id) {
    Post postDB = postRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    postRepository.delete(postDB);
  }
}
