package com.company.blog.post.controller;

import com.company.blog.post.model.Comment;
import com.company.blog.post.model.Post;
import com.company.blog.post.service.CommentService;
import com.company.blog.post.service.PostService;
import com.company.blog.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public String getSinglePost(@PathVariable long id, @PageableDefault(size = 10) Pageable pageable, @AuthenticationPrincipal User user, Model model) {
        log.info("getSinglePost({})", id);
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("commentPage", commentService.getCommentsByPost(post, pageable));
        model.addAttribute("newComment", new Comment());
        return "post/single-post";
    }
}
