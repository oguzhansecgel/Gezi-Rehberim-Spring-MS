package com.gezi_rehberim.user_service.service.concretes.user;

import com.gezi_rehberim.user_service.core.dto.request.user.RoleRequest;
import com.gezi_rehberim.user_service.core.mapper.RoleMapping;
import com.gezi_rehberim.user_service.models.Role;
import com.gezi_rehberim.user_service.repository.RoleRepository;
import com.gezi_rehberim.user_service.service.abstracts.user.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role addRole(RoleRequest request) {
        Role role = RoleMapping.INSTANCE.roleFromRequest(request);
        System.out.println("Mapped Role Name: " + role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
    }

    @Override
    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of();
    }
}