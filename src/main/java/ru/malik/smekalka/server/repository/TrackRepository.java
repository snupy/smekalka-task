package ru.malik.smekalka.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malik.smekalka.server.domain.Track;

public interface TrackRepository extends JpaRepository<Track, String> {
}
