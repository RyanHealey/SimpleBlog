package com.ryanhealey.simpleblogbackend.service;

import com.ryanhealey.simpleblogbackend.domain.CurrentUserEntity;
import com.ryanhealey.simpleblogbackend.dto.CurrentUserDto;
import com.ryanhealey.simpleblogbackend.mappers.CurrentUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CurrentUserService {
    private CurrentUserEntity currentUser;
    @Autowired
    private final CurrentUserMapper mapper;
    @Autowired
    private final UserService userService;

    public CurrentUserService(CurrentUserMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
        this.currentUser = CurrentUserEntity.builder().user(this.userService.getDefaultUser()).build();
    }

    public CurrentUserEntity getCurrentUser(){
        return currentUser;
    }

    public CurrentUserDto getCurrentUserDto() {
        return mapper.entityToDto(currentUser);
    }

    public CurrentUserDto updateCurrentUserDto(UUID id) {
        currentUser.setUser(userService.getUserEntityById(id).get());
        return mapper.entityToDto(currentUser);
    }
}
