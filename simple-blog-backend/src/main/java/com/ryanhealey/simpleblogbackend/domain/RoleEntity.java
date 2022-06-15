package com.ryanhealey.simpleblogbackend.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.UUID;
@Entity
@Table(name = "role")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BlogEntity<UUID> {

    private String name;
}
