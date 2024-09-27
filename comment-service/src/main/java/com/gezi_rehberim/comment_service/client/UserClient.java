package com.gezi_rehberim.comment_service.client;

import com.gezi_rehberim.comment_service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "User")
public interface UserClient {

    @GetMapping("/api/users/getByIdUser/{id}")
    Optional<User> getUserById(@PathVariable("id") int id);
}
