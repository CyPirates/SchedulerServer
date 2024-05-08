package com.example.schedulerserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
    int statusCode;
    String message;

    public static ErrorResponse of(ResponseStatusException e){
        return ErrorResponse.builder()
                .statusCode(e.getStatusCode().value())
                .message(e.getReason())
                .build();
    }
}
