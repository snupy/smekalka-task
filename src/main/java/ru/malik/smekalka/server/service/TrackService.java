package ru.malik.smekalka.server.service;

import ru.malik.smekalka.server.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    void add(Track track);

    void update(Track track);

    List<Track> getAll();

    Optional<Track> get(String id);
}
