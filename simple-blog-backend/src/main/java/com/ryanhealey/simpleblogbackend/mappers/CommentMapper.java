package com.ryanhealey.simpleblogbackend.mappers;

import com.ryanhealey.simpleblogbackend.domain.CommentEntity;
import com.ryanhealey.simpleblogbackend.domain.PostEntity;
import com.ryanhealey.simpleblogbackend.dto.CommentDto;
import com.ryanhealey.simpleblogbackend.dto.PostDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentMapper {

    private final UserMapper userMapper;

    private final PostMapper postMapper;
    
    public CommentDto entityToDto(CommentEntity entity) {
        return CommentDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .user(userMapper.entityToDto(entity.getUser()))
                .post(postMapper.entityToDto(entity.getPost()))
                .build();
    }
}
