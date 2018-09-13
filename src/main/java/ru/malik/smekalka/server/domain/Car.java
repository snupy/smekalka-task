package ru.malik.smekalka.server.domain;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car implements Persistable<String> {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String code;
    @Enumerated(EnumType.ORDINAL)
    private TransmissionType transmission;
    private boolean ai;
    private double maxSpeed;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    private boolean aNew = true;

    @Override
    public boolean isNew() {
        return aNew;
    }

    public void setNew(boolean aNew) {
        this.aNew = aNew;
    }
}
