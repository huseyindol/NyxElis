package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;
import com.nyxelis.entity.Customer;
import com.nyxelis.entity.Post;
import com.nyxelis.mapper.PostMapper;
import com.nyxelis.repository.CustomerRepository;
import com.nyxelis.repository.PostRepository;
import com.nyxelis.service.IPostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PostMapper postMapper;

    @Override
    public DtoPost postFindById(Long id) {
        Post postDB = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
        return postMapper.toPostDto(postDB);
    }

    @Override
    public DtoPost postFindBySlug(String slug) {
        Post postDB = postRepository.findBySlug(slug).orElseThrow(() -> new EntityNotFoundException("Post not found with slug: " + slug));
        return postMapper.toPostDto(postDB);
    }

    @Override
    public DtoPost createPost(DtoPostIU dtoPost) {
        Post postEntity = postMapper.toPostIUEntity(dtoPost);
        Customer author = customerRepository.findById(dtoPost.getAuthorId()).orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + dtoPost.getAuthorId()));
        if (author == null) {
            throw new EntityNotFoundException("Author not found with id: " + dtoPost.getAuthorId());
        }
        postEntity.setAuthor(author);
        Post saved = postRepository.save(postEntity);
        return postMapper.toPostDto(saved);
    }

    @Override
    public DtoPost updatePost(Long id, DtoPostIU dtoPost) {
        Post post =
                postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found width id:" + id));
        // DTO'dan gelen alanları var olan entity üzerine uygula
        postMapper.updatePostEntityFromDto(dtoPost, post);
        // updatedAt otomatik setlenebilir, gerekiyorsa burada da el ile yazılabilir
        Post updatePost = postRepository.save(post);
        return postMapper.toPostDto(updatePost);
    }

    @Override
    public void deletePost(Long id) {
        Post postDB = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
        postRepository.delete(postDB);
    }
}
