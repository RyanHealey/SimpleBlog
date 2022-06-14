package com.ryanhealey.simpleblogbackend.dto;

import com.ryanhealey.simpleblogbackend.domain.RoleEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class UserDto {

    private UUID id;

    private String name;

    private RoleDto role;
}
