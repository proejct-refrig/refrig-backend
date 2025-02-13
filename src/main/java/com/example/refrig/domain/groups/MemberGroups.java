package com.example.refrig.domain.groups;

import com.example.refrig.api.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "memberGroup")
public class MemberGroups extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
}
