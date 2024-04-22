package com.example.schedulerserver.domain.map.repository;

import com.example.schedulerserver.domain.map.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
