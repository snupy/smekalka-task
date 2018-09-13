package ru.malik.smekalka.server.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.malik.smekalka.server.domain.LengthUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LengthUnitJsonDeserializerTest {
    private LengthUnitJsonDeserializer sub;

    @BeforeEach
    public void setUp() {
        sub = new LengthUnitJsonDeserializer();
    }

    @Test
    public void testDeserializeShouldReturnKilometer() throws Exception {
        final String json = "\"km\"";
        final LengthUnit value = Utils.deserializeValue(sub, json);
        assertEquals(LengthUnit.KILOMETER, value);
    }

    @Test
    public void testDeserializeShouldThrow() throws Exception {
        final String json = "\"ABC\"";
        assertThrows(IllegalArgumentException.class, () -> {
            Utils.deserializeValue(sub, json);
        });
    }
}