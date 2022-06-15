package com.ryanhealey.simpleblogbackend.repository;

import com.ryanhealey.simpleblogbackend.domain.BlogEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BlogRepository<E extends BlogEntity> extends Repository<E, UUID> {
    List<E> findAll();

    List<E> findAllByActive(final Boolean active);

    Optional<E> findById(final UUID id);

    Optional<E> findByIdAndActive(final UUID id, final Boolean active);

    E save(final E entity);
}
