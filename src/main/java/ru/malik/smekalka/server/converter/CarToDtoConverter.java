package ru.malik.smekalka.server.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.malik.smekalka.server.domain.Car;
import ru.malik.smekalka.server.domain.SpeedUnit;
import ru.malik.smekalka.server.dto.CarDto;
import ru.malik.smekalka.server.dto.SpeedDto;

@Component
public class CarToDtoConverter implements Converter<Car, CarDto> {
    @Override
    public CarDto convert(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .code(car.getCode())
                .ai(car.isAi())
                .transmission(car.getTransmission())
                .maxSpeed(getMaxSpeed(car))
                .build();
    }

    private SpeedDto getMaxSpeed(Car car) {
        final SpeedUnit unit = SpeedUnit.METER_PER_SECOND;
        return SpeedDto.builder()
                .value(unit.fromSI(car.getMaxSpeed()))
                .unit(unit)
                .build();
    }
}
