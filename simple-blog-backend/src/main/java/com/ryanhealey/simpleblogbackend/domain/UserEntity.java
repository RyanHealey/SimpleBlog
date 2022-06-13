package com.ryanhealey.simpleblogbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="user")
@Data
public class UserEntity extends BlogEntity<UUID> {

    private String name;

    @ManyToOne
    private RoleEntity role;
}
