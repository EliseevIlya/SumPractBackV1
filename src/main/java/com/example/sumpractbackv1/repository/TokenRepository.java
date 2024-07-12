package com.example.sumpractbackv1.repository;

import com.example.sumpractbackv1.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {

    Optional<Token> findByAccessToken(String accessToken);

    Optional<Token> findByRefreshToken(String refreshToken);

    void deleteByAccessToken(String accessToken);

    void deleteByRefreshToken(String refreshToken);

}
