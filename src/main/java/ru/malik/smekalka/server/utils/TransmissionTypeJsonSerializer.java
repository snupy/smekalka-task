package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.malik.smekalka.server.domain.TransmissionType;

import java.io.IOException;

public class TransmissionTypeJsonSerializer extends JsonSerializer<TransmissionType> {
    @Override
    public void serialize(TransmissionType type, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(type.name().toLowerCase());
    }
}
