package com.ryanhealey.simpleblogbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "post")
@Data
public class PostEntity extends BlogEntity<UUID> {

    private String content;

    @JoinColumn(name="user_id")
    @ManyToOne
    private UserEntity userEntity;
}
