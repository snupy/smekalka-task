package ru.malik.smekalka.server.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomBooleanJsonDeserializerTest {
    private CustomBooleanJsonDeserializer sub;

    @BeforeEach
    public void setUp() {
        sub = new CustomBooleanJsonDeserializer();
    }

    @Test
    public void testDeserializeShouldReturnTrue() throws Exception {
        final String json = "\"enabled\"";
        final boolean value = Utils.deserializeValue(sub, json);
        assertTrue(value);
    }

    @Test
    public void testDeserializeShouldReturnFalse() throws Exception {
        final String json = "\"disable\"";
        final boolean value = Utils.deserializeValue(sub, json);
        assertFalse(value);
    }
}