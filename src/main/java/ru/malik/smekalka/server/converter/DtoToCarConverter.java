package ru.malik.smekalka.server.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.malik.smekalka.server.domain.Car;
import ru.malik.smekalka.server.dto.CarDto;
import ru.malik.smekalka.server.dto.SpeedDto;

@Component
public class DtoToCarConverter implements Converter<CarDto, Car> {
    @Override
    public Car convert(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .ai(carDto.isAi())
                .code(carDto.getCode())
                .transmission(carDto.getTransmission())
                .maxSpeed(getSpeed(carDto.getMaxSpeed()))
                .build();
    }

    private double getSpeed(SpeedDto s) {
        return s.getUnit().toSI(s.getValue());
    }
}
