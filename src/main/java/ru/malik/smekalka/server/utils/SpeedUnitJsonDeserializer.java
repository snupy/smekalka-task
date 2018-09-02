package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.malik.smekalka.server.domain.SpeedUnit;

import java.io.IOException;

public class SpeedUnitJsonDeserializer extends JsonDeserializer<SpeedUnit> {
    @Override
    public SpeedUnit deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final String s = jsonParser.getText();
        switch (s) {
            case "mps":
                return SpeedUnit.METER_PER_SECOND;
            default:
                throw new IllegalArgumentException("Unknown speed unit " + s);
        }
    }
}
