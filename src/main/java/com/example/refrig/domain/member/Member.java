package com.example.refrig.domain.member;

import com.example.refrig.api.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    private String provider;
    private String providerUserId;
    private String email;
    private String name;
}
