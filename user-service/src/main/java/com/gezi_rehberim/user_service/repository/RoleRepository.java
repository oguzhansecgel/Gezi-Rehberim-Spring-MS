package com.gezi_rehberim.user_service.repository;

import com.gezi_rehberim.user_service.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
