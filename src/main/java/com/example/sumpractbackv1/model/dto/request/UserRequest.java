package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String username;

    private String password;

    private Role role;
}
