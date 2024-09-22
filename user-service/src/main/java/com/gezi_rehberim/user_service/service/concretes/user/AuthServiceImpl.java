package com.gezi_rehberim.user_service.service.concretes.user;

import com.gezi_rehberim.user_service.core.dto.request.user.LoginRequest;
import com.gezi_rehberim.user_service.core.dto.request.user.RegisterRequest;
import com.gezi_rehberim.user_service.core.dto.response.user.LoginResponse;
import com.gezi_rehberim.user_service.core.mapper.UserMapping;
import com.gezi_rehberim.user_service.models.User;
import com.gezi_rehberim.user_service.service.abstracts.user.AuthService;
import com.gezi_rehberim.user_service.service.abstracts.user.UserService;
import com.turkcell.tcell.core.security.BaseJwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final BaseJwtService baseJwtService;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserService userService, AuthenticationManager authenticationManager, BaseJwtService baseJwtService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.baseJwtService = baseJwtService;
    }

    @Override
    public void register(RegisterRequest request) {

        User user = UserMapping.INSTANCE.userFromRequest(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.add(user);

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        if (!authentication.isAuthenticated()) {
            throw new RuntimeException("E-posta ya da şifre yanlış");
        }

        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        int userId = ((User) user).getId();
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = user
                .getAuthorities()
                .stream()
                .map((role) -> role.getAuthority())
                .toList();
        claims.put("roles", roles);
        claims.put("userId",userId);
        String token = baseJwtService.generateToken(loginRequest.getEmail(), claims);


        return new LoginResponse(token, userId);
    }
}
