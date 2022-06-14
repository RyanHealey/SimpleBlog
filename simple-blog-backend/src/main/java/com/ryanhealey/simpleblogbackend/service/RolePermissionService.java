package com.ryanhealey.simpleblogbackend.service;

import com.ryanhealey.simpleblogbackend.domain.RoleEntity;
import com.ryanhealey.simpleblogbackend.domain.RolePermissionEntity;
import com.ryanhealey.simpleblogbackend.repository.RolePermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolePermissionService {
    private final RolePermissionRepository rolePermissionRepository;

    public List<RolePermissionEntity> getRolePermissionsForRole(RoleEntity role){
        return rolePermissionRepository.findByRoleEntityAndActive(role, Boolean.TRUE);
    }
}
