package com.example.schedulerserver.domain.map.service;

import com.example.schedulerserver.domain.map.dto.LocationDto;
import com.example.schedulerserver.domain.map.entity.Location;
import com.example.schedulerserver.domain.map.repository.LocationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "DailyPlaylistRankingService")
@Transactional
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location save(Location location, double longitude, double latitude) {
        if (location == null) {
            location = Location.builder().build();
        }

        location.setLongitude(longitude);
        location.setLatitude(latitude);
        return locationRepository.save(location);
    }

    public LocationDto.Response getLocationDto(Location location) {
        return LocationDto.Response.builder()
                .updateDate(location.getUpdateDate().toString())
                .longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .build();
    }
}
