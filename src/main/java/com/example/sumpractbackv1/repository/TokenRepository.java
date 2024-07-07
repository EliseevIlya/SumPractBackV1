package com.example.sumpractbackv1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sumpractbackv1.model.entity.Token;

public interface TokenRepository extends JpaRepository<Token, String> {
	
	Optional<Token> findByAccessToken(String accessToken);

	Optional<Token> findByRefreshToken(String refreshToken);
	
}
