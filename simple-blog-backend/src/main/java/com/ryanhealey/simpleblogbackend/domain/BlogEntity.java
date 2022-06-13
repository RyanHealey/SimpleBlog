package com.ryanhealey.simpleblogbackend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@SuperBuilder
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class BlogEntity<ID> {

    @Id
    private ID id;

    private Integer active;
}
