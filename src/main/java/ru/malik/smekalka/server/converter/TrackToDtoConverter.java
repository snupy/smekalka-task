package ru.malik.smekalka.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.malik.smekalka.server.domain.LengthUnit;
import ru.malik.smekalka.server.domain.Track;
import ru.malik.smekalka.server.dto.LengthDto;
import ru.malik.smekalka.server.dto.TrackDto;

import java.util.stream.Collectors;

@Component
public class TrackToDtoConverter implements Converter<Track, TrackDto> {

    private final CarToDtoConverter carToDtoConverter;

    @Autowired
    public TrackToDtoConverter(CarToDtoConverter carToDtoConverter) {
        this.carToDtoConverter = carToDtoConverter;
    }

    @Override
    public TrackDto convert(Track track) {
        return TrackDto.builder()
                .name(track.getName())
                .id(track.getId())
                .description(track.getDescription())
                .length(getLegth(track))
                .cars(track.getCars().stream().map(carToDtoConverter::convert).collect(Collectors.toList()))
                .build();
    }

    private LengthDto getLegth(Track track) {
        final LengthUnit unit = LengthUnit.KILOMETER;
        return LengthDto.builder()
                .unit(unit)
                .value(unit.fromSI(track.getLength()))
                .build();
    }
}
