package com.example.refrig.domain.groups;

import com.example.refrig.api.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "home")
public class Home extends BaseEntity {
    @Column(name = "home_name")
    private String homeName;
}
