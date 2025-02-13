package com.example.refrig.domain.consumption;

import com.example.refrig.api.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consumptionLog")
public class ConsumptionLog extends BaseEntity {

    @Column(name = "action_type")
    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @Column(name = "quantity")
    private Integer quantity;

    private LocalDateTime actionDate;



}
