package com.company.blog.user.controller;

import com.company.blog.user.model.User;
import com.company.blog.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/public/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String getAllUsers(@PageableDefault(size = 10) Pageable pageable, Model model) {
        model.addAttribute("usersPage", userService.getAllUsers(pageable));
        return "user/user-list";
    }

    @GetMapping("/new")
    public String getNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/new-user";
    }

    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new-user";
        }
        userService.addUser(user);
        return "redirect:/public/post";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/private/user";
    }
}
