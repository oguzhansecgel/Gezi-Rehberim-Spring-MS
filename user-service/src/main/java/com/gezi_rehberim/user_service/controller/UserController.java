package com.gezi_rehberim.user_service.controller;

import com.gezi_rehberim.user_service.core.dto.response.user.UserResponse;
import com.gezi_rehberim.user_service.service.abstracts.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUser();
    }
}
