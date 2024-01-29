package com.example.onefitclone.user.permission;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.user.permission.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface PermissionRepository extends GenericRepository<Permission, UUID> {
    Set<Permission> findAllByName(Set<String> names);
}
