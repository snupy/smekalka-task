package ru.malik.smekalka.server.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Track {
    @Id
    private String id;
    private String name;
    private String description;
    private double length;
    @OneToMany
    private List<Car> cars;
}
