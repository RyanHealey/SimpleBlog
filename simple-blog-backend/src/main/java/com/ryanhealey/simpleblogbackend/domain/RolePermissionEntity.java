package com.ryanhealey.simpleblogbackend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="role_permission")
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePermissionEntity extends BlogEntity<UUID> {

    @JoinColumn(name="role_id")
    @ManyToOne
    private RoleEntity roleEntity;

    private Long permission;

    private Long permissionLevel;
}
