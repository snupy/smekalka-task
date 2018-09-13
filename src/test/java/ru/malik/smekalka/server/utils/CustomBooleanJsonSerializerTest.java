package ru.malik.smekalka.server.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomBooleanJsonSerializerTest {
    private CustomBooleanJsonSerializer sub;

    @BeforeEach
    void setUp() {
        sub = new CustomBooleanJsonSerializer();
    }

    @ParameterizedTest
    @MethodSource
    void testSerialize(final TestData testData) throws IOException {
        final String res = Utils.serializeValue(sub, testData.value);

        assertEquals(testData.json, res);
    }

    private static Stream<TestData> testSerialize() {
        return Stream.of(new TestData(true, "\"enabled\""), new TestData(false, "\"disabled\""));
    }

    @Getter
    @AllArgsConstructor
    private static class TestData {
        private Boolean value;
        private String json;
    }
}