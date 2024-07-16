package com.example.sumpractbackv1.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseEntityRequest {

    @Schema(description = "идентификатор")
    private Long id;

}
