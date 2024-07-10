package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.model.dto.JwtAuthenticationResponse;
import com.example.sumpractbackv1.model.dto.SignInRequest;
import com.example.sumpractbackv1.model.entity.Token;
import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.repository.TokenRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @param response ответ
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        var accessToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        tokenRepository.save(Token.builder()
                .user((User) user)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build());

        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        // cookie.setSecure(true);
        cookie.setPath("/api/auth/refresh");
        cookie.setMaxAge(30 * 24 * 60 * 60);

        response.addCookie(cookie);

        return new JwtAuthenticationResponse(accessToken);
    }

    /**
     * Обновление токена
     *
     * @param refreshToken токен
     * @param response ответ
     * @return новый токен
     */
    public JwtAuthenticationResponse refreshToken(String refreshToken, HttpServletResponse response) {
        try {
            var username = jwtService.extractUserName(refreshToken);

            if (StringUtils.isNotEmpty(username)) {
                Optional<Token> token = tokenRepository.findByRefreshToken(refreshToken);
                if (token.isPresent()) {
                    var user = token.get().getUser();

                    if (jwtService.isTokenValid(refreshToken, user)) {
                        var accessToken = jwtService.generateAccessToken(user);
                        var newRefreshToken = jwtService.generateRefreshToken(user);
                        tokenRepository.save(Token.builder()
                                .user(user)
                                .accessToken(accessToken)
                                .refreshToken(newRefreshToken)
                                .build());
                        tokenRepository.delete(token.get());

                        Cookie cookie = new Cookie("refreshToken", newRefreshToken);
                        cookie.setHttpOnly(true);
                        // cookie.setSecure(true);
                        cookie.setPath("/api/auth/refresh");
                        cookie.setMaxAge(30 * 24 * 60 * 60);

                        response.addCookie(cookie);

                        return new JwtAuthenticationResponse(accessToken);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Выход пользователя
     *
     * @param accessToken токен
     * @param refreshToken токен
     * @param response ответ
     * @throws IOException в случае ошибки при работе с HTTP ответом
     */
    public void signOut(String accessToken, String refreshToken, HttpServletResponse response) {
        if (StringUtils.isNotEmpty(accessToken)) {
            tokenRepository.deleteByAccessToken(accessToken);
        }
        if (StringUtils.isNotEmpty(refreshToken)) {
            tokenRepository.deleteByRefreshToken(refreshToken);
        }
        var cookie = new Cookie("refreshToken", "");
        cookie.setHttpOnly(true);
        // cookie.setSecure(true);
        cookie.setPath("/api/auth/refresh");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
	
}
