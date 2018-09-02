package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.malik.smekalka.server.domain.LengthUnit;

import java.io.IOException;

public class LengthUnitJsonSerializer extends JsonSerializer<LengthUnit> {
    @Override
    public void serialize(LengthUnit unit, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        final String s;
        switch (unit) {
            case KILOMETER:
                s = "km";
                break;
            default:
                throw new IllegalArgumentException("Unsupported LengthUnit " + unit);
        }
        jsonGenerator.writeString(s);
    }
}
