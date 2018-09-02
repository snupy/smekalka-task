package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomBooleanJsonSerializer extends JsonSerializer<Boolean> {
    @Override
    public void serialize(Boolean aBoolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(aBoolean ? "enabled" : "disabled");
    }
}
