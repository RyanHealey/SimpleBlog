package com.ryanhealey.simpleblogbackend.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.UUID;
@Entity
@Table(name = "role")
@Data
public class RoleEntity extends BlogEntity<UUID> {

    private String name;
}
