package com.ryanhealey.simpleblogbackend.mappers;

import com.ryanhealey.simpleblogbackend.domain.CurrentUserEntity;
import com.ryanhealey.simpleblogbackend.dto.CurrentUserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrentUserMapper implements BlogMapper<CurrentUserEntity, CurrentUserDto>{

    private final UserMapper userMapper;

    public CurrentUserDto entityToDto(CurrentUserEntity entity) {
        return CurrentUserDto.builder()
                .user(userMapper.entityToDto(entity.getUser()))
                .build();
    }

    @Override
    public CurrentUserEntity dtoToEntity(CurrentUserDto dto) {
        return CurrentUserEntity.builder()
                .user(userMapper.dtoToEntity(dto.getUser()))
                .build();
    }
}
