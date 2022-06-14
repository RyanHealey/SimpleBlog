package com.ryanhealey.simpleblogbackend.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ryanhealey.simpleblogbackend.domain.CurrentUserEntity;
import com.ryanhealey.simpleblogbackend.domain.UserEntity;
import com.ryanhealey.simpleblogbackend.dto.UserDto;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserMapper {

    private final RoleMapper roleMapper;
    public UserDto entityToDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .role(roleMapper.entityToDto(entity.getRole()))
                .build();
    };
}
