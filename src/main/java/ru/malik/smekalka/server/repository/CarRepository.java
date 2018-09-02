package ru.malik.smekalka.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malik.smekalka.server.domain.Car;

public interface CarRepository extends JpaRepository<Car, String> {
}
