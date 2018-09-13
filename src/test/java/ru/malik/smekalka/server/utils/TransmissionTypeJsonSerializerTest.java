package ru.malik.smekalka.server.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.malik.smekalka.server.domain.TransmissionType;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransmissionTypeJsonSerializerTest {
    private TransmissionTypeJsonSerializer sub;

    @BeforeEach
    void setUp() {
        sub = new TransmissionTypeJsonSerializer();
    }

    @ParameterizedTest
    @MethodSource
    void testSerialize(final TestData testData) throws IOException {
        final String res = Utils.serializeValue(sub, testData.value);

        assertEquals(testData.json, res);
    }

    private static Stream<TestData> testSerialize() {
        return Stream.of(TransmissionType.values())
                .map(tt ->
                        new TestData(
                                tt, String.format("\"%s\"", tt.name().toLowerCase())
                        )
                );
    }

    @Getter
    @AllArgsConstructor
    private static class TestData {
        private TransmissionType value;
        private String json;
    }
}