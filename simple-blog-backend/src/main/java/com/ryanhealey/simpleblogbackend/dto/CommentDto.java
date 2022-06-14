package com.ryanhealey.simpleblogbackend.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class CommentDto {
    private UUID id;

    private String content;

    private UserDto user;

    private PostDto post;
}
