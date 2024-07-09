package com.example.sumpractbackv1.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.service.UserService;


public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public @NonNull Optional<String> getCurrentAuditor() {
		return UserService.getCurrentUser().map(User::getUsername);
	}
	
}
