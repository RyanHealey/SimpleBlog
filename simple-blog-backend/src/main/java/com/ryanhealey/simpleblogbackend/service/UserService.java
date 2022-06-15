package com.ryanhealey.simpleblogbackend.service;

import com.ryanhealey.simpleblogbackend.domain.UserEntity;
import com.ryanhealey.simpleblogbackend.dto.UserDto;
import com.ryanhealey.simpleblogbackend.mappers.BlogMapper;
import com.ryanhealey.simpleblogbackend.mappers.UserMapper;
import com.ryanhealey.simpleblogbackend.repository.BlogRepository;
import com.ryanhealey.simpleblogbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends BlogService<UserEntity, UserDto, UserMapper, UserRepository> {

    private final UUID DEFAULT_USER_ID = UUID.fromString("62128dcb-ab76-4949-9166-2184a9e0e4f7");

    public UserService(BlogMapper<UserEntity, UserDto> mapper, BlogRepository<UserEntity> repository) {
        super(mapper, repository);
    }

    public Optional<UserEntity> getUserEntityById(UUID id){
        return this.getRepository().findByIdAndActive(id, Boolean.TRUE);
    }
    public UserEntity getDefaultUser(){
        return getUserEntityById(DEFAULT_USER_ID).get();
    }
}
