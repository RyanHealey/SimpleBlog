package com.ryanhealey.simpleblogbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@NoArgsConstructor
public class CommentDto extends BlogDto {

    private String content;

    private UserDto user;

    private PostDto post;
}
