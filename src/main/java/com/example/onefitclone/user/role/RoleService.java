package com.example.onefitclone.user.role;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.user.permission.PermissionRepository;
import com.example.onefitclone.user.permission.entity.Permission;
import com.example.onefitclone.user.role.dto.RoleCreatedDto;
import com.example.onefitclone.user.role.dto.RoleResponseDto;
import com.example.onefitclone.user.role.dto.RoleUpdateDto;
import com.example.onefitclone.user.role.entity.Role;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
@Transactional
public class RoleService extends GenericService<Role, UUID, RoleCreatedDto, RoleResponseDto, RoleUpdateDto> {
    private final RoleRepository repository;
    private final PermissionRepository permissionRepository;
    private final Class<Role> entityClass = Role.class;
    private final RoleDtoMapper mapper;
    @Override
    protected RoleResponseDto internalCreate(RoleCreatedDto roleCreatedDto) {
        Role entity = mapper.toEntity(roleCreatedDto);

        Set<String> dtoPermissionNames = roleCreatedDto.getPermission();
        Set<Permission> permissions = permissionRepository.findAllByName(roleCreatedDto.getPermission());

        if (dtoPermissionNames.size() != permissions.size()) {
            Set<String> permissionNames = permissions
                    .stream()
                    .map(Permission::getName)
                    .collect(Collectors.toSet());

            dtoPermissionNames.removeAll(permissionNames);

            throw new EntityNotFoundException("No permissions found for this name. Permissions: %s".formatted(dtoPermissionNames));
        }

        entity.setPermissions(permissions);

        Role saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected RoleResponseDto internalUpdate(UUID uuid, RoleUpdateDto roleUpdateDto) {
        return null;

    }
    public RoleResponseDto getByName(String name) {
        Role role = repository
                .findByName(name)
                .orElseThrow(
                        () -> new EntityNotFoundException("With the name of the role: %s not found".formatted(name))
                );
        return mapper.toResponseDto(role);
    }
}
