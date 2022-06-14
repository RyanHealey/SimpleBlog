package com.ryanhealey.simpleblogbackend.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ryanhealey.simpleblogbackend.domain.CurrentUserEntity;
import com.ryanhealey.simpleblogbackend.dto.CurrentUserDto;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrentUserMapper {

    private final UserMapper userMapper;

    public CurrentUserDto entityToDto(CurrentUserEntity entity) {
        return CurrentUserDto.builder()
                .user(userMapper.entityToDto(entity.getUser()))
                .build();
    }
}
