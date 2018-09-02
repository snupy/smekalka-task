package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.malik.smekalka.server.domain.TransmissionType;

import java.io.IOException;

public class TransmissionTypeJsonDeserializer extends JsonDeserializer<TransmissionType> {
    @Override
    public TransmissionType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final String s = jsonParser.getText();
        return TransmissionType.valueOf(s.toUpperCase());
    }
}
