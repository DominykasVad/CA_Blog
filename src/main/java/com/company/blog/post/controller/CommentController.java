package com.company.blog.post.controller;

import com.company.blog.post.model.Comment;
import com.company.blog.post.service.CommentService;
import com.company.blog.post.service.PostService;
import com.company.blog.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        comment.setAuthor(user);
        comment.setPost(postService.getPostById(comment.getPostId()));
        Comment savedComment = commentService.addComment(comment);
        return "redirect:/public/post/" + savedComment.getPost().getId();
    }

    @GetMapping("/edit/{id}")
    public String getEditCommentForm(@PathVariable long id, Model model) {
        model.addAttribute("comment", commentService.getCommentById(id));
        return "post/edit-comment";
    }

    @PostMapping("/edit-comment")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String updateComment(@ModelAttribute("comment") Comment comment, @AuthenticationPrincipal User user) {
        Comment originalComment = commentService.getCommentById(comment.getId());
        if (originalComment.getAuthor().getId() == user.getId()) {
            commentService.updateComment(comment);
        }
        return "redirect:/public/post/" + originalComment.getPost().getId();
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteComment(@PathVariable long id) {
        long commentPostId = commentService.getCommentById(id).getPost().getId();
        commentService.deleteCommentById(id);
        return "redirect:/public/post/" + commentPostId;
    }
}
