package ru.malik.smekalka.server.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.malik.smekalka.MockitoExtension;
import ru.malik.smekalka.server.domain.Car;
import ru.malik.smekalka.server.domain.LengthUnit;
import ru.malik.smekalka.server.domain.Track;
import ru.malik.smekalka.server.dto.CarDto;
import ru.malik.smekalka.server.dto.LengthDto;
import ru.malik.smekalka.server.dto.TrackDto;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrackToDtoConverterTest {
    @InjectMocks
    private TrackToDtoConverter sub;

    @Mock
    private CarToDtoConverter carToDtoConverter;

    @Test
    void testConvert() {
        final Car car = new Car();
        final CarDto carDto = new CarDto();

        final Track track = Track.builder()
                .id("ID")
                .name("NAME")
                .description("DES")
                .length(1000)
                .cars(Collections.singletonList(car))
                .build();

        when(carToDtoConverter.convert(car)).thenReturn(carDto);

        final TrackDto res = sub.convert(track);

        assertEquals(res.getId(), "ID");
        assertEquals(res.getDescription(), "DES");
        assertEquals(res.getName(), "NAME");
        assertEquals(res.getLength(), new LengthDto(1, LengthUnit.KILOMETER));

        assertThat(res.getCars(), contains(sameInstance(carDto)));
    }
}