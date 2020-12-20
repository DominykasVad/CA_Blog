package com.company.blog.post.controller;

import com.company.blog.post.service.CommentService;
import com.company.blog.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("public/post")
public class PostController {

    private PostService postService;
    private CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping
    public String getAllPosts(@PageableDefault(size = 9) Pageable pageable, Model model) {
        model.addAttribute("postPage", postService.getAllPosts(pageable));
        return "post/post-list";
    }
}
