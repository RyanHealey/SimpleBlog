package com.ryanhealey.simpleblogbackend.mappers;

import com.ryanhealey.simpleblogbackend.domain.PostEntity;
import com.ryanhealey.simpleblogbackend.dto.PostDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostMapper implements BlogMapper<PostEntity, PostDto>{

    private final UserMapper userMapper;

    public PostDto entityToDto(PostEntity entity) {
        return PostDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .user(userMapper.entityToDto(entity.getUserEntity()))
                .build();
    }

    public PostEntity dtoToEntity(PostDto dto) {
        return PostEntity.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .userEntity(dto.getUser() != null ? userMapper.dtoToEntity(dto.getUser()) : null)
                .build();
    }
}
