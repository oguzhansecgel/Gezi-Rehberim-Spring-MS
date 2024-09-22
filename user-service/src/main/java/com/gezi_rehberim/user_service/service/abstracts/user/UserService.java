package com.gezi_rehberim.user_service.service.abstracts.user;

import com.gezi_rehberim.user_service.core.dto.response.user.UserResponse;
import com.gezi_rehberim.user_service.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void add(User user);

    Optional<User> getUserById(int id);
    List<UserResponse> getAllUser();
}
