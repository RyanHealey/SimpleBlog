package com.ryanhealey.simpleblogbackend.service;

import com.ryanhealey.simpleblogbackend.domain.UserEntity;
import com.ryanhealey.simpleblogbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UUID DEFAULT_USER_ID = UUID.fromString("62128dcb-ab76-4949-9166-2184a9e0e4f7");
    private final UserRepository userRepository;
    public Optional<UserEntity> getUserById(UUID id){
        return userRepository.findByIdAndActive(id, Boolean.TRUE);
    }
    public UserEntity getDefaultUser(){
        return getUserById(DEFAULT_USER_ID).get();
    }
}
