package com.company.blog.post.service;

import com.company.blog.post.exception.CommentNotFoundException;
import com.company.blog.post.model.Comment;
import com.company.blog.post.model.Post;
import com.company.blog.post.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Page<Comment> getCommentsByPost(Post post, Pageable pageable) {
        return commentRepository.getCommentsByPost(post, pageable);
    }

    public Comment getCommentById(long id) {
        return commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(Comment newComment) {
        Comment comment = commentRepository.getOne(newComment.getId());
        comment.setContent(newComment.getContent());
    }

    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

}
