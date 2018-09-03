package ru.malik.smekalka.server.domain;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Track implements Persistable<String> {
    @Id
    private String id;
    private String name;
    private String description;
    private double length;
    @OneToMany
    private List<Car> cars;
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
