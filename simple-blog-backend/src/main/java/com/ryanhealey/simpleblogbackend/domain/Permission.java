package com.ryanhealey.simpleblogbackend.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Permission {
    USERS(1L,"Users"),
    POSTS(2L,"Posts"),
    COMMENTS(3L,"Comments");


    private final Long id;
    private final String name;
}
