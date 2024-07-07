package com.example.sumpractbackv1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.sumpractbackv1.model.entity.User;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersistenceConfig {

	@Bean
    AuditorAware<User> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }
	
}
