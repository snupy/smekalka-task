package ru.malik.smekalka.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.malik.smekalka.server.converter.DtoToTrackConverter;
import ru.malik.smekalka.server.converter.TrackToDtoConverter;
import ru.malik.smekalka.server.domain.SpeedUnit;
import ru.malik.smekalka.server.domain.Track;
import ru.malik.smekalka.server.dto.CarDto;
import ru.malik.smekalka.server.dto.SpeedDto;
import ru.malik.smekalka.server.dto.TrackDto;
import ru.malik.smekalka.server.service.TrackService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/1/tracks")
public class TrackController {

    private final TrackService trackService;
    private final TrackToDtoConverter trackToDtoConverter;
    private final DtoToTrackConverter dtoToTrackConverter;

    @Autowired
    public TrackController(TrackService trackService, TrackToDtoConverter trackToDtoConverter, DtoToTrackConverter dtoToTrackConverter) {
        this.trackService = trackService;
        this.trackToDtoConverter = trackToDtoConverter;
        this.dtoToTrackConverter = dtoToTrackConverter;
    }


    @GetMapping(path = "/{id}")
    public TrackDto get(@PathVariable("id") String id) {
        return trackService.get(id)
                .map(trackToDtoConverter::convert)
                .orElseGet(() -> {
                    throw new TrackNotFoundException();
                });
        /*return TrackDto.builder()
                .cars(Collections.singletonList(CarDto.builder()
                        .ai(true)
                        .maxSpeed(SpeedDto.builder()
                                .unit(SpeedUnit.METER_PER_SECOND).value(1).build())
                        .build()))
                .build();*/
    }

    @GetMapping
    public List<TrackDto> getAll() {
        return trackService.getAll().stream().map(trackToDtoConverter::convert).collect(Collectors.toList());
    }

    @PostMapping
    public String add(@RequestBody TrackDto dto) {
        final Track track = dtoToTrackConverter.convert(dto);
        trackService.add(track);
        return track.getId();
    }

    @PutMapping
    public String update(@RequestBody TrackDto dto) {
        final Track track = dtoToTrackConverter.convert(dto);
        trackService.update(track);
        return track.getId();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class TrackNotFoundException extends RuntimeException {
        public TrackNotFoundException() {
            super("track not found");
        }
    }
}
