package ru.malik.smekalka.server.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
class DtoToTrackConverterTest {
    @InjectMocks
    private DtoToTrackConverter sub;

    @Mock
    private DtoToCarConverter dtoToCarConverter;

    @Test
    void testConvert() {
        final Car car = new Car();
        final CarDto carDto = new CarDto();
        final TrackDto dto = TrackDto.builder()
                .id("ID")
                .length(new LengthDto(1.0, LengthUnit.KILOMETER))
                .description("DES")
                .cars(Collections.singletonList(carDto))
                .name("NAME")
                .build();

        when(dtoToCarConverter.convert(carDto)).thenReturn(car);

        final Track res = sub.convert(dto);

        assertEquals(res.getId(), "ID");
        assertEquals(res.getDescription(), "DES");
        assertEquals(res.getName(), "NAME");
        assertEquals(res.getLength(), 1000);

        assertThat(res.getCars(), contains(sameInstance(car)));
    }
}