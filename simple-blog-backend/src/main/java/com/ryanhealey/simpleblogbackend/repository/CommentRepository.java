package com.ryanhealey.simpleblogbackend.repository;

import com.ryanhealey.simpleblogbackend.domain.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface CommentRepository extends Repository<UserEntity, UUID> {

}
