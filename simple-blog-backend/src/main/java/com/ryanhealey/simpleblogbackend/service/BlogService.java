package com.ryanhealey.simpleblogbackend.service;

import com.ryanhealey.simpleblogbackend.domain.BlogEntity;
import com.ryanhealey.simpleblogbackend.dto.BlogDto;
import com.ryanhealey.simpleblogbackend.mappers.BlogMapper;
import com.ryanhealey.simpleblogbackend.repository.BlogRepository;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class BlogService<E extends BlogEntity, D extends BlogDto, m extends BlogMapper, r extends BlogRepository> {
    private final BlogMapper<E, D> mapper;
    private final BlogRepository<E> repository;

    public List<D> getAll(){
        return repository.findAllByActive(true).stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public UUID add(D dto){
        var entity = mapper.dtoToEntity(dto);
        entity.setActive(true);
        var id = UUID.randomUUID();
        entity.setId(id);
        repository.save(entity);
        return id;
    }

    public void delete(UUID id) throws FileNotFoundException {
        var entity = repository.findById(id).orElseThrow(FileNotFoundException::new);
        entity.setActive(false);
        repository.save(entity);
    }

    public D getById(UUID id) throws FileNotFoundException {
        return mapper.entityToDto(
                repository.findByIdAndActive(id, true)
                        .orElseThrow(FileNotFoundException::new)
        );

    }

    protected BlogRepository<E> getRepository(){
        return this.repository;
    }

    protected BlogMapper<E,D> getMapper(){
        return this.mapper;
    }
}
