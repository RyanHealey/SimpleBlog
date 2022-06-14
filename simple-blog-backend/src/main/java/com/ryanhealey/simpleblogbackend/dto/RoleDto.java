package com.ryanhealey.simpleblogbackend.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Builder
@Getter
public class RoleDto {
    private UUID id;

    private String name;

    private Map<Long,Long> permissions;
}
