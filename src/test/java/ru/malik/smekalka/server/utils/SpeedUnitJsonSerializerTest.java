package ru.malik.smekalka.server.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.malik.smekalka.server.domain.LengthUnit;
import ru.malik.smekalka.server.domain.SpeedUnit;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpeedUnitJsonSerializerTest {
    private SpeedUnitJsonSerializer sub;

    @BeforeEach
    void setUp() {
        sub = new SpeedUnitJsonSerializer();
    }

    @Test
    void testSerialize() throws IOException {
        final String res =  Utils.serializeValue(sub, SpeedUnit.METER_PER_SECOND);
        assertEquals("\"mps\"", res);
    }
}