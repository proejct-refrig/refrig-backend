package com.example.refrig.domain.item;

import com.example.refrig.api.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class Item extends BaseEntity {

    @Column(name = "name")
    private String name;

    private Integer quantity;

    private LocalDateTime expiryDate;


}
