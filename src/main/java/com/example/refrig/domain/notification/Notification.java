package com.example.refrig.domain.notification;

import com.example.refrig.api.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {
    private String message;
    private boolean isRead;

}
