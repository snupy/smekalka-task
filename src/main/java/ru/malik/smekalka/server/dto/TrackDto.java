package ru.malik.smekalka.server.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackDto {
    private String id;
    private String name;
    private String description;
    private LengthDto length;
    private List<CarDto> cars;
}
