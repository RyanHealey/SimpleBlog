package com.ryanhealey.simpleblogbackend.service;

import com.ryanhealey.simpleblogbackend.domain.CommentEntity;
import com.ryanhealey.simpleblogbackend.domain.PostEntity;
import com.ryanhealey.simpleblogbackend.dto.CommentDto;
import com.ryanhealey.simpleblogbackend.dto.PostDto;
import com.ryanhealey.simpleblogbackend.mappers.BlogMapper;
import com.ryanhealey.simpleblogbackend.mappers.CommentMapper;
import com.ryanhealey.simpleblogbackend.mappers.PostMapper;
import com.ryanhealey.simpleblogbackend.repository.BlogRepository;
import com.ryanhealey.simpleblogbackend.repository.CommentRepository;
import com.ryanhealey.simpleblogbackend.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends BlogService<CommentEntity, CommentDto, CommentMapper, CommentRepository> {
    public CommentService(BlogMapper<CommentEntity, CommentDto> mapper, BlogRepository<CommentEntity> repository) {
        super(mapper, repository);
    }
}
