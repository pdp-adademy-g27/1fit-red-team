package com.example.onefitclone.user.role;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.user.role.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface RoleRepository extends GenericRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
