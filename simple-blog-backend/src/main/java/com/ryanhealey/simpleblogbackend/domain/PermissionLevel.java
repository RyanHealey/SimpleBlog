package com.ryanhealey.simpleblogbackend.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PermissionLevel {
    NONE(1L, "None"),
    READ(2L, "READ"),
    CREATE(3L, "Create"),
    EDIT(4L,"Edit");

    private final Long id;

    private final String name;
}
