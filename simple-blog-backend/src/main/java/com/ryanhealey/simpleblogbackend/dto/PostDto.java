package com.ryanhealey.simpleblogbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Getter
@NoArgsConstructor
public class PostDto extends BlogDto {

    private String content;

    private UserDto user;
}
