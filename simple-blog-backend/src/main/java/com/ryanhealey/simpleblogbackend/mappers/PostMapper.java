package com.ryanhealey.simpleblogbackend.mappers;

import com.ryanhealey.simpleblogbackend.domain.PostEntity;
import com.ryanhealey.simpleblogbackend.domain.UserEntity;
import com.ryanhealey.simpleblogbackend.dto.PostDto;
import com.ryanhealey.simpleblogbackend.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostMapper {

    private final UserMapper userMapper;

    public PostDto entityToDto(PostEntity entity) {
        return PostDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .user(userMapper.entityToDto(entity.getUserEntity()))
                .build();
    }
}
