package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.malik.smekalka.server.domain.LengthUnit;
import ru.malik.smekalka.server.domain.SpeedUnit;

import java.io.IOException;

public class LengthUnitJsonDeserializer extends JsonDeserializer<LengthUnit> {
    @Override
    public LengthUnit deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final String s = jsonParser.getText();
        switch (s) {
            case "km":
                return LengthUnit.KILOMETER;
            default:
                throw new IllegalArgumentException("Unknown length unit " + s);
        }
    }
}
