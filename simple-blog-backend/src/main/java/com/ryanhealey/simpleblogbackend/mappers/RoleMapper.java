package com.ryanhealey.simpleblogbackend.mappers;

import com.ryanhealey.simpleblogbackend.domain.RoleEntity;
import com.ryanhealey.simpleblogbackend.domain.RolePermissionEntity;
import com.ryanhealey.simpleblogbackend.dto.RoleDto;
import com.ryanhealey.simpleblogbackend.service.RolePermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@AllArgsConstructor
@Service
public class RoleMapper {
    private final RolePermissionService rolePermissionService;

    public RoleDto entityToDto(RoleEntity entity){
        return RoleDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .permissions(buildPermissions(entity))
                .build();
    };

    private Map<Long, Long> buildPermissions(final RoleEntity entity) {
        return rolePermissionService.getRolePermissionsForRole(entity).stream()
                .collect(toMap(RolePermissionEntity::getPermission, RolePermissionEntity::getPermissionLevel));
    }
}
