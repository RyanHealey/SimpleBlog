package com.ryanhealey.simpleblogbackend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "post")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostEntity extends BlogEntity<UUID> {

    private String content;

    @JoinColumn(name="user_id")
    @ManyToOne
    private UserEntity userEntity;
}
