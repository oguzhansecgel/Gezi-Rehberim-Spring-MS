package com.gezi_rehberim.user_service.core.mapper;

import com.gezi_rehberim.user_service.core.dto.request.user.RegisterRequest;
import com.gezi_rehberim.user_service.core.dto.response.user.GetByIdUserResponse;
import com.gezi_rehberim.user_service.core.dto.response.user.UserResponse;
import com.gezi_rehberim.user_service.models.Role;
import com.gezi_rehberim.user_service.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapping {

    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    User userFromRequest(RegisterRequest request);

    GetByIdUserResponse getByIdUserResponse(User user);

    @Mapping(target = "roleId", source = "roles", qualifiedByName = "mapRolesToRoleId")
    UserResponse userFromResponse(User user);
    List<UserResponse> usersFromResponse(List<User> users);

    @Named("mapRolesToRoleId")
    default int mapRolesToRoleId(Set<Role> roles) {
        // Implement your logic here. For example, return the ID of the first role if present.
        return roles.isEmpty() ? 0 : roles.iterator().next().getId();
    }
}
