package ru.malik.smekalka.server.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.malik.smekalka.server.domain.Car;
import ru.malik.smekalka.server.domain.SpeedUnit;
import ru.malik.smekalka.server.domain.TransmissionType;
import ru.malik.smekalka.server.dto.CarDto;
import ru.malik.smekalka.server.dto.SpeedDto;

import static org.junit.jupiter.api.Assertions.*;

class DtoToCarConverterTest {
    private DtoToCarConverter sub;

    @BeforeEach
    void setUp() {
        sub = new DtoToCarConverter();
    }

    @Test
    void testConvert() {
        final CarDto dto = CarDto.builder()
                .id("ID")
                .code("CODE")
                .ai(true)
                .maxSpeed(new SpeedDto(1.0, SpeedUnit.METER_PER_SECOND))
                .transmission(TransmissionType.AUTOMATIC)
                .build();

        final Car res = sub.convert(dto);

        assertEquals(res.getId(), "ID");
        assertEquals(res.getCode(), "CODE");
        assertTrue(res.isAi());
        assertEquals(res.getMaxSpeed(), 1.0);
        assertEquals(res.getTransmission(), TransmissionType.AUTOMATIC);
        assertFalse(res.isNew());
    }
}