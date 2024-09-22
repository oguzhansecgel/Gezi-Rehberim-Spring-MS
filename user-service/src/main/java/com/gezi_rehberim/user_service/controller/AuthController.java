package com.gezi_rehberim.user_service.controller;

import com.gezi_rehberim.user_service.core.dto.request.user.LoginRequest;
import com.gezi_rehberim.user_service.core.dto.request.user.RegisterRequest;
import com.gezi_rehberim.user_service.core.dto.response.user.LoginResponse;
import com.gezi_rehberim.user_service.service.abstracts.user.AuthService;
import com.gezi_rehberim.user_service.service.abstracts.user.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;
    private final RoleService roleService;

    @PostMapping("register")
    public void register( @RequestBody RegisterRequest request)
    {
        authService.register(request);
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request)
    {
        return authService.login(request);
    }
}