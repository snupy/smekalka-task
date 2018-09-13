package ru.malik.smekalka.server.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import ru.malik.smekalka.server.domain.SpeedUnit;
import ru.malik.smekalka.server.utils.SpeedUnitJsonDeserializer;
import ru.malik.smekalka.server.utils.SpeedUnitJsonSerializer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class SpeedDto {
    private double value;
    @JsonDeserialize(using = SpeedUnitJsonDeserializer.class)
    @JsonSerialize(using = SpeedUnitJsonSerializer.class)
    private SpeedUnit unit;
}
