package com.ryanhealey.simpleblogbackend.mappers;

public interface BlogMapper<E,D> {

    public D entityToDto(E entity);

    public E dtoToEntity(D dto);

}
