package com.ryanhealey.simpleblogbackend.mappers;

import com.ryanhealey.simpleblogbackend.domain.CommentEntity;
import com.ryanhealey.simpleblogbackend.dto.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentMapper implements BlogMapper<CommentEntity, CommentDto>{

    private final UserMapper userMapper;

    private final PostMapper postMapper;

    public CommentDto entityToDto(CommentEntity entity) {
        return  CommentDto.builder()
                .content(entity.getContent())
                .user(userMapper.entityToDto(entity.getUser()))
                .post(postMapper.entityToDto(entity.getPost()))
                .id(entity.getId())
                .build();
    }

    public CommentEntity dtoToEntity(CommentDto dto){
        return CommentEntity.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .user(userMapper.dtoToEntity(dto.getUser()))
                .post(postMapper.dtoToEntity(dto.getPost()))
                .build();
    }
}
