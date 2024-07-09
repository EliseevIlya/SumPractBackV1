package com.example.sumpractbackv1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.model.enums.Role;
import com.example.sumpractbackv1.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppInitializer {
    private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	
	@Value("${admin.username}")
	private String adminUsername;
	@Value("${admin.password}")
	private String adminPassword;

	@PostConstruct
    public void initialize() {
        boolean admin = userRepository.existsByUsername(adminUsername);
        if (!admin) {
            User newUser = User.builder()
				.username(adminUsername)
				.password(passwordEncoder.encode(adminPassword))
				.role(Role.ADMIN)
				.build();
            userRepository.save(newUser);
        }
    }

}
