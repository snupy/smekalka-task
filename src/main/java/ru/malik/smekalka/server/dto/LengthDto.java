package ru.malik.smekalka.server.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import ru.malik.smekalka.server.domain.LengthUnit;
import ru.malik.smekalka.server.utils.LengthUnitJsonDeserializer;
import ru.malik.smekalka.server.utils.LengthUnitJsonSerializer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LengthDto {
    private double value;
    @JsonDeserialize(using = LengthUnitJsonDeserializer.class)
    @JsonSerialize(using = LengthUnitJsonSerializer.class)
    private LengthUnit unit;
}
