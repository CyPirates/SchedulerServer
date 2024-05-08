package com.example.schedulerserver.global.common.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class ResponseBody<T> {
    @NotNull
    @Schema(example = "200")
    private int status;
    @NotBlank
    @Schema(example = "성공")
    private String message;
    private T data;
}
