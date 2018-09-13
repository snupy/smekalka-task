package ru.malik.smekalka.server.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

class Utils {

    private static ObjectMapper mapper;

    static ObjectMapper defaultMapper() {
        if (mapper == null) mapper = new ObjectMapper();
        return mapper;
    }

    static <T> T deserializeValue(ObjectMapper mapper, JsonDeserializer<T> deserializer, String json) throws IOException {
        final InputStream stream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        final JsonParser parser = mapper.getFactory().createParser(stream);
        final DeserializationContext ctxt = mapper.getDeserializationContext();
        parser.nextToken();
        return deserializer.deserialize(parser, ctxt);
    }

    static <T> T deserializeValue(JsonDeserializer<T> deserializer, String json) throws IOException {
        return deserializeValue(defaultMapper(), deserializer, json);
    }

    static <T> String serializeValue(ObjectMapper mapper, JsonSerializer<T> serializer, T value) throws IOException {
        final Writer jsonWriter = new StringWriter();
        final JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
        final SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();

        serializer.serialize(value, jsonGenerator, serializerProvider);
        jsonGenerator.flush();

        return jsonWriter.toString();
    }

    static <T> String serializeValue(JsonSerializer<T> serializer, T value) throws IOException {
        return serializeValue(defaultMapper(), serializer, value);
    }
}
