package ru.malik.smekalka.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import ru.malik.smekalka.server.domain.TransmissionType;
import ru.malik.smekalka.server.utils.CustomBooleanJsonDeserializer;
import ru.malik.smekalka.server.utils.CustomBooleanJsonSerializer;
import ru.malik.smekalka.server.utils.TransmissionTypeJsonDeserializer;
import ru.malik.smekalka.server.utils.TransmissionTypeJsonSerializer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private String id;
    private String code;
    @JsonDeserialize(using = TransmissionTypeJsonDeserializer.class)
    @JsonSerialize(using = TransmissionTypeJsonSerializer.class)
    private TransmissionType transmission;
    @JsonDeserialize(using = CustomBooleanJsonDeserializer.class)
    @JsonSerialize(using = CustomBooleanJsonSerializer.class)
    private boolean ai;
    @JsonProperty("max-speed")
    private SpeedDto maxSpeed;
}
