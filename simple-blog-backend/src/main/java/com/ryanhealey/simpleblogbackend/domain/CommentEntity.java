package com.ryanhealey.simpleblogbackend.domain;

import lombok.Builder;
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
@Table(name="comment")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class CommentEntity extends BlogEntity<UUID>{

    private String content;

    @JoinColumn(name="user_id")
    @ManyToOne
    private UserEntity user;

    @JoinColumn(name="post_id")
    @ManyToOne
    private PostEntity post;

}
