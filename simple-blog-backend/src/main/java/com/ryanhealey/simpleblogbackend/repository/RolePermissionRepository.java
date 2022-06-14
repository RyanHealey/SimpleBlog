package com.ryanhealey.simpleblogbackend.repository;

import com.ryanhealey.simpleblogbackend.domain.RoleEntity;
import com.ryanhealey.simpleblogbackend.domain.RolePermissionEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RolePermissionRepository extends Repository<RolePermissionEntity, UUID> {
    public List<RolePermissionEntity> findByRoleEntityAndActive(RoleEntity roleEntity, Boolean active);
}
