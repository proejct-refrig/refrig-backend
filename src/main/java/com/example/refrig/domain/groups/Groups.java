package com.example.refrig.domain.groups;

import com.example.refrig.api.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups")
public class Groups extends BaseEntity {
    @Column(name = "group_name")
    private String groupName;
}
