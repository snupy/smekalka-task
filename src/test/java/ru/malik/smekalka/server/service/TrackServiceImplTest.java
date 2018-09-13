package ru.malik.smekalka.server.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.malik.smekalka.MockitoExtension;
import ru.malik.smekalka.server.domain.Car;
import ru.malik.smekalka.server.domain.Track;
import ru.malik.smekalka.server.domain.TransmissionType;
import ru.malik.smekalka.server.repository.CarRepository;
import ru.malik.smekalka.server.repository.TrackRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrackServiceImplTest {
    @InjectMocks
    private TrackServiceImpl sub;

    @Mock
    private CarRepository carRep;
    @Mock
    private TrackRepository trackRep;

    private Car car;
    private Track track;

    @BeforeEach
    void setUp() {
        car = new Car("ID", "CODE", TransmissionType.AUTOMATIC, true, 1.0, true);
        track = new Track("ID", "NAME", "DES", 1.0, Collections.singletonList(car), true);
    }

    @Test
    void testGetAll() {
        final List<Track> tracks = Collections.singletonList(track);
        when(trackRep.findAll()).thenReturn(tracks);
        final List<Track> res = sub.getAll();

        assertEquals(tracks, res);
    }

    @Test
    void testAdd() {
        car.setNew(false);
        track.setNew(false);

        sub.add(track);

        verify(carRep).saveAll(Collections.singletonList(car));
        verify(trackRep).save(track);

        assertTrue(car.isNew());
        assertTrue(track.isNew());
    }

    @Test
    void testUpdate() {
        car.setNew(true);
        track.setNew(true);

        sub.update(track);

        verify(carRep).saveAll(Collections.singletonList(car));
        verify(trackRep).save(track);

        assertFalse(car.isNew());
        assertFalse(track.isNew());
    }

    @Test
    void testGet() {
        final String id = "ID";
        final Optional opt = Optional.of(track);
        when(trackRep.findById(id)).thenReturn(opt);

        final Optional<Track> res = sub.get(id);

        assertEquals(opt, res);
    }
}