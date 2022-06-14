package com.ryanhealey.simpleblogbackend.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CurrentUserDto {
    private UserDto user;
}
