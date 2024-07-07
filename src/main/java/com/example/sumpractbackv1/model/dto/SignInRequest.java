package com.example.sumpractbackv1.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {

	@Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
	private String username;
	
    @NotBlank(message = "Пароль не может быть пустыми")
	private String password;
	
}
