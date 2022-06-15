package com.ryanhealey.simpleblogbackend.service;

import com.ryanhealey.simpleblogbackend.domain.PostEntity;
import com.ryanhealey.simpleblogbackend.dto.PostDto;
import com.ryanhealey.simpleblogbackend.mappers.BlogMapper;
import com.ryanhealey.simpleblogbackend.mappers.PostMapper;
import com.ryanhealey.simpleblogbackend.repository.BlogRepository;
import com.ryanhealey.simpleblogbackend.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService extends BlogService<PostEntity, PostDto, PostMapper, PostRepository> {
    public PostService(BlogMapper<PostEntity, PostDto> mapper, BlogRepository<PostEntity> repository) {
        super(mapper, repository);
    }
}
