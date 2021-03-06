package com.company.blog.post.controller;

import com.company.blog.post.model.Comment;
import com.company.blog.post.model.Post;
import com.company.blog.post.service.CommentService;
import com.company.blog.post.service.PostService;
import com.company.blog.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("commentPage", commentService.getCommentsByPost(post, pageable));
        model.addAttribute("newComment", new Comment());
        return "post/single-post";
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String getNewPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/new-post";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String addPost(@ModelAttribute("post") Post post, @AuthenticationPrincipal User user) {
        post.setAuthor(user);
        Post savedPost = postService.addPost(post);
        return "redirect:/public/post/" + savedPost.getId();
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deletePost(@PathVariable long id) {
        log.info("deletePost({})", id);
        postService.deletePostById(id);
        return "redirect:/public/post";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post/edit-post";
    }

    @PostMapping("/edit-post")
    @PreAuthorize("hasRole('ADMIN')")
    public String editPost(@ModelAttribute("post") Post post) {
        postService.updatePost(post);
        return "redirect:/public/post/" + post.getId();
    }
}
