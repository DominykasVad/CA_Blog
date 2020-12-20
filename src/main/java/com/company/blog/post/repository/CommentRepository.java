package com.company.blog.post.repository;

import com.company.blog.post.model.Comment;
import com.company.blog.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> getCommentsByPost(Post post, Pageable pageable);
}
