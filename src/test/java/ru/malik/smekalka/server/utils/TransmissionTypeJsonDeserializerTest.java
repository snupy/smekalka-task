package ru.malik.smekalka.server.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.malik.smekalka.server.domain.TransmissionType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransmissionTypeJsonDeserializerTest {
    private TransmissionTypeJsonDeserializer sub;

    @BeforeEach
    public void setUp() {
        sub = new TransmissionTypeJsonDeserializer();
    }

    @ParameterizedTest
    @EnumSource(TransmissionType.class)
    public void testDeserializeShouldReturnKilometer(TransmissionType tt) throws Exception {
        final String json = String.format("\"%s\"", tt.name().toLowerCase());
        final TransmissionType value = Utils.deserializeValue(sub, json);
        assertEquals(tt, value);
    }

    @Test
    public void testDeserializeShouldThrow() throws Exception {
        final String json = "\"ABC\"";
        assertThrows(IllegalArgumentException.class, () -> {
            Utils.deserializeValue(sub, json);
        });
    }
}