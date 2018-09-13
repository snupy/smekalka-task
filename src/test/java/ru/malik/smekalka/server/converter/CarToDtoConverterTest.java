package ru.malik.smekalka.server.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.malik.smekalka.server.domain.Car;
import ru.malik.smekalka.server.domain.SpeedUnit;
import ru.malik.smekalka.server.domain.TransmissionType;
import ru.malik.smekalka.server.dto.CarDto;
import ru.malik.smekalka.server.dto.SpeedDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarToDtoConverterTest {
    private CarToDtoConverter sub;

    @BeforeEach
    void setUp() {
        sub = new CarToDtoConverter();
    }

    @Test
    void testConvert() {
        final Car car = Car.builder()
                .id("ID")
                .code("CODE")
                .ai(true)
                .maxSpeed(1.0)
                .transmission(TransmissionType.AUTOMATIC)
                .aNew(false)
                .build();

        final CarDto exp = CarDto.builder()
                .id("ID")
                .code("CODE")
                .ai(true)
                .maxSpeed(new SpeedDto(1.0, SpeedUnit.METER_PER_SECOND))
                .transmission(TransmissionType.AUTOMATIC)
                .build();

        final CarDto res = sub.convert(car);

        assertEquals(exp, res);
    }
}