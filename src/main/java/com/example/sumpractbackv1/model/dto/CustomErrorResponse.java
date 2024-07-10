package com.example.sumpractbackv1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse<T> {

    @Builder.Default
    private Instant timestamp = new Date().toInstant();

    @Builder.Default
    private int status = 500;

    @Builder.Default
    private String error = "Internal Server Error";

    private T message;

    private String path;

}
