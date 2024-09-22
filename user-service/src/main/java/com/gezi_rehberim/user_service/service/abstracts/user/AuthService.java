package com.gezi_rehberim.user_service.service.abstracts.user;

import com.gezi_rehberim.user_service.core.dto.request.user.LoginRequest;
import com.gezi_rehberim.user_service.core.dto.request.user.RegisterRequest;
import com.gezi_rehberim.user_service.core.dto.response.user.LoginResponse;

public interface AuthService {
    void register(RegisterRequest request);

    LoginResponse login(LoginRequest loginRequest);
}
