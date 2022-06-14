package com.ryanhealey.simpleblogbackend.repository;

import com.ryanhealey.simpleblogbackend.domain.RoleEntity;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface RoleRepository extends Repository<RoleEntity, UUID> {

}
