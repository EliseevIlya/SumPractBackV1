package com.example.sumpractbackv1.config;

import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.service.controllersServices.UserService;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import java.util.Optional;


public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public @NonNull Optional<String> getCurrentAuditor() {
        return UserService.getCurrentUser().map(User::getUsername);
    }

}
