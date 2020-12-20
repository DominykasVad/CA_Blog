package com.company.blog.post.service;

import com.company.blog.post.exception.PostNotFoundException;
import com.company.blog.post.model.Post;
import com.company.blog.post.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post getPostById(long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public void updatePost(Post newPost) {
        Post post = postRepository.getOne(newPost.getId());
        post.setPostTitle(newPost.getPostTitle());
        post.setPostContent(newPost.getPostContent());
    }
}
