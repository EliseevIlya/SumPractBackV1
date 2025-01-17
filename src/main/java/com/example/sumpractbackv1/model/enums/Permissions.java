package com.example.sumpractbackv1.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permissions {
    READ_DATA("READ_DATA"),
    EDIT_DATA("EDIT_DATA"),
    CREATE_USER("CREATE_USER");

    @Getter
    private final String permission;
}
