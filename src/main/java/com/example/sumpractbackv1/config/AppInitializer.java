package com.example.sumpractbackv1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.model.enums.Role;
import com.example.sumpractbackv1.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class AppInitializer {
    private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@Value("${file.upload-dir}")
	private String uploadDir;
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
		try {
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
    }

}
