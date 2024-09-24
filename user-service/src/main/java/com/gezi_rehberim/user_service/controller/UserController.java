package com.gezi_rehberim.user_service.controller;

import com.gezi_rehberim.user_service.core.dto.response.user.GetByIdUserResponse;
import com.gezi_rehberim.user_service.core.dto.response.user.UserResponse;
import com.gezi_rehberim.user_service.service.abstracts.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getByIdUser/{id}")
    public Optional<GetByIdUserResponse> getByIdUser(@PathVariable int id)
    {
        return userService.getUserById(id);
    }
    @GetMapping("/getAllUsers")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUser();
    }
}
