package com.ryanhealey.simpleblogbackend.repository;

import com.ryanhealey.simpleblogbackend.domain.CommentEntity;
import com.ryanhealey.simpleblogbackend.domain.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends BlogRepository<CommentEntity> {

    List<CommentEntity> findAllByPostIdAndActive(UUID post, Boolean active);
}
