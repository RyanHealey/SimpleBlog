package com.ryanhealey.simpleblogbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@Getter
public class RoleDto extends BlogDto {

    private String name;

    private Map<Long,Long> permissions;
}
