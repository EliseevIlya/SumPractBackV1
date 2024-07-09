package com.example.sumpractbackv1.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sumpractbackv1.model.dto.CustomErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApplicationErrorHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CustomErrorResponse<Map<String, String>> handleInvalidRequest(MethodArgumentNotValidException e, HttpServletRequest request) {
		Map<String, String> errorMap = new HashMap<>();

		e.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return CustomErrorResponse.<Map<String, String>>builder()
			.status(400)
			.error("Bad Request")
			.message(errorMap)
			.path(request.getRequestURI())
			.build();
	}
	
}
