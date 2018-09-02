package ru.malik.smekalka.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malik.smekalka.server.domain.Track;
import ru.malik.smekalka.server.repository.CarRepository;
import ru.malik.smekalka.server.repository.TrackRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private final CarRepository carRep;
    private final TrackRepository trackRep;

    @Autowired
    public TrackServiceImpl(CarRepository carRep, TrackRepository trackRep) {
        this.carRep = carRep;
        this.trackRep = trackRep;
    }

    @Override
    public void add(Track track) {
        carRep.saveAll(track.getCars());
        trackRep.save(track);
    }

    @Override
    public void update(Track track) {
        carRep.saveAll(track.getCars());
        trackRep.save(track);
    }

    @Override
    public List<Track> getAll() {
        return trackRep.findAll();
    }

    @Override
    public Optional<Track> get(String id) {
        return trackRep.findById(id);
    }
}
