package com.ryanhealey.simpleblogbackend.mappers;

import com.ryanhealey.simpleblogbackend.domain.UserEntity;
import com.ryanhealey.simpleblogbackend.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserMapper implements BlogMapper<UserEntity, UserDto>{

    private final RoleMapper roleMapper;
    public UserDto entityToDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .role(roleMapper.entityToDto(entity.getRole()))
                .build();
    };

    public UserEntity dtoToEntity(UserDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .role(dto.getRole() != null ? roleMapper.dtoToEntity(dto.getRole()) : null)
                .build();
    }
}
