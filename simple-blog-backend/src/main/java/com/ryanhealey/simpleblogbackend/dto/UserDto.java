package com.ryanhealey.simpleblogbackend.dto;

import com.ryanhealey.simpleblogbackend.domain.RoleEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@Getter
public class UserDto extends BlogDto {

    private UUID id;

    private String name;

    private RoleDto role;
}
