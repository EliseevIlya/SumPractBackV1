package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.Role;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Date;

import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class UserSearchCriteria {

    @Parameter(description = "Фильтр по Id")
    @Positive(message = "Id должен быть больше нуля")
    private Long id;

    @Parameter(description = "Поиск по имени")
    private String searchUsername;

    @Parameter(description = "Фильтр по роли")
    private Role role;

    @Parameter(description = "Поиск по дате создания")
    private Date fromCreatedAt;

    @Parameter(description = "Поиск по дате создания")
    private Date toCreatedAt;

}