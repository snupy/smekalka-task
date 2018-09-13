package ru.malik.smekalka.server.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.malik.smekalka.server.domain.LengthUnit;
import ru.malik.smekalka.server.domain.SpeedUnit;

import static org.junit.jupiter.api.Assertions.*;

class SpeedUnitJsonDeserializerTest {
    private SpeedUnitJsonDeserializer sub;

    @BeforeEach
    public void setUp() {
        sub = new SpeedUnitJsonDeserializer();
    }

    @Test
    public void testDeserializeShouldReturnMps() throws Exception {
        final String json = "\"mps\"";
        final SpeedUnit value = Utils.deserializeValue(sub, json);
        assertEquals(SpeedUnit.METER_PER_SECOND, value);
    }

    @Test
    public void testDeserializeShouldThrow() throws Exception {
        final String json = "\"ABC\"";
        assertThrows(IllegalArgumentException.class, () -> {
            Utils.deserializeValue(sub, json);
        });
    }
}