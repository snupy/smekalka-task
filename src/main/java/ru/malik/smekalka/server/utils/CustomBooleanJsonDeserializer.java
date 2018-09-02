package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomBooleanJsonDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return "enabled".equals(jsonParser.getText());
    }
}
