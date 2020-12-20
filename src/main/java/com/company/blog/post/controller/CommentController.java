package com.company.blog.post.controller;

import com.company.blog.post.model.Comment;
import com.company.blog.post.service.CommentService;
import com.company.blog.post.service.PostService;
import com.company.blog.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("private/comment")
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping
    public String addComment(@ModelAttribute("comment") Comment comment, @AuthenticationPrincipal User user) {
        log.info("addComment({})", comment);
        comment.setAuthor(user);
        comment.setPost(postService.getPostById(comment.getPostId()));
        Comment savedComment = commentService.addComment(comment);
        return "redirect:/public/post/" + savedComment.getPost().getId();
    }
}
