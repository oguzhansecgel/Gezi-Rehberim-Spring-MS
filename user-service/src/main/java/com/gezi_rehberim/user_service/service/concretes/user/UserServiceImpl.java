package com.gezi_rehberim.user_service.service.concretes.user;

import com.gezi_rehberim.user_service.core.dto.response.user.GetByIdUserResponse;
import com.gezi_rehberim.user_service.core.dto.response.user.UserResponse;
import com.gezi_rehberim.user_service.core.exception.user.UserNotFoundException;
import com.gezi_rehberim.user_service.core.mapper.UserMapping;
import com.gezi_rehberim.user_service.core.message.user.UserMessage;
import com.gezi_rehberim.user_service.models.User;
import com.gezi_rehberim.user_service.repository.UserRepositories;
import com.gezi_rehberim.user_service.service.abstracts.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public void add(User user) {
        userRepositories.save(user);
    }

    @Override
    public Optional<GetByIdUserResponse> getUserById(int id) {
        Optional<User> user = userRepositories.findById(id);
        if (user.isEmpty())
        {
            throw new UserNotFoundException(UserMessage.USER_NOT_FOUND);
        }
        return user.map(UserMapping.INSTANCE::getByIdUserResponse);
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = userRepositories.findAll();
        return UserMapping.INSTANCE.usersFromResponse(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepositories.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with email or password "));

    }
}
