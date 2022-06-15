package com.ryanhealey.simpleblogbackend.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class CurrentUserEntity {
    private UserEntity user;
}
