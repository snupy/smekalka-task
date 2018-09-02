package ru.malik.smekalka.server.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Car {
    @Id
    private String id;
    private String code;
    @Enumerated(EnumType.ORDINAL)
    private TransmissionType transmission;
    private boolean ai;
    private double maxSpeed;
}
