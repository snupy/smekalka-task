package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.malik.smekalka.server.domain.SpeedUnit;

import java.io.IOException;

public class SpeedUnitJsonSerializer extends JsonSerializer<SpeedUnit> {
    @Override
    public void serialize(SpeedUnit unit, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        final String s;
        switch (unit) {
            case METER_PER_SECOND:
                s = "mps";
                break;
            default:
                throw new IllegalArgumentException("Unsupported SpeedUnit " + unit);
        }
        jsonGenerator.writeString(s);
    }
}
