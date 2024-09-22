package com.gezi_rehberim.user_service.service.abstracts.user;

import com.gezi_rehberim.user_service.core.dto.request.user.RoleRequest;
import com.gezi_rehberim.user_service.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role addRole(RoleRequest request);

    void deleteRole(int id);

    Optional<Role> getRoleById(int id);

    List<Role> getAllRoles();
}