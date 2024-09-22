package com.gezi_rehberim.user_service.core.mapper;

import com.gezi_rehberim.user_service.core.dto.request.user.RoleRequest;
import com.gezi_rehberim.user_service.core.dto.response.user.RoleWithUserResponse;
import com.gezi_rehberim.user_service.models.Role;
import com.gezi_rehberim.user_service.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapping {

    RoleMapping INSTANCE = Mappers.getMapper(RoleMapping.class);

    Role roleFromRequest(RoleRequest request);

    @Mapping(source = "roleId", target = "id")
    Role toRole(RoleWithUserResponse roleWithUserResponse);

    @Mapping(source = "userId", target = "id")
    User toUser(RoleWithUserResponse roleWithUserResponse);
}