package com.example.schedulerserver.domain.map.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class LocationDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "LocationResponse", description = "위치 정보 응답")
    public static class Response {
        private String updateDate;
        private double longitude;
        private double latitude;
    }
}
