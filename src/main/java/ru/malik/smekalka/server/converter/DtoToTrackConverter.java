package ru.malik.smekalka.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.malik.smekalka.server.domain.Track;
import ru.malik.smekalka.server.dto.LengthDto;
import ru.malik.smekalka.server.dto.TrackDto;

import java.util.stream.Collectors;

@Component
public class DtoToTrackConverter implements Converter<TrackDto, Track> {

    private final DtoToCarConverter dtoToCarConverter;

    @Autowired
    public DtoToTrackConverter(DtoToCarConverter dtoToCarConverter) {
        this.dtoToCarConverter = dtoToCarConverter;
    }

    @Override
    public Track convert(TrackDto dto) {
        return Track.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .length(getLegth(dto.getLength()))
                .cars(dto.getCars().stream().map(dtoToCarConverter::convert).collect(Collectors.toList()))
                .build();
    }

    private double getLegth(LengthDto l) {
        return l.getUnit().toSI(l.getValue());
    }
}
