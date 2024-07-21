package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.model.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;
    
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;

    private Role role;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .role(role)
                .build();
    }
}
