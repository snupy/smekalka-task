package ru.malik.smekalka.server.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.malik.smekalka.server.domain.LengthUnit;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LengthUnitJsonSerializerTest {

    private LengthUnitJsonSerializer sub;

    @BeforeEach
    void setUp() {
        sub = new LengthUnitJsonSerializer();
    }

    @Test
    void testSerialize() throws IOException {
        final String res =  Utils.serializeValue(sub, LengthUnit.KILOMETER);
        assertEquals("\"km\"", res);
    }
}