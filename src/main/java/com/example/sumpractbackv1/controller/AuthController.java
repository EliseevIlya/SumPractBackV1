package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.config.JwtAuthenticationFilter;
import com.example.sumpractbackv1.model.dto.JwtAuthenticationResponse;
import com.example.sumpractbackv1.model.dto.SignInRequest;
import com.example.sumpractbackv1.service.AuthenticationService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request, HttpServletResponse response) {
        return authenticationService.signIn(request, response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return ResponseEntity.status(401).build();
        }

        String refreshToken = null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refreshToken")) {
                refreshToken = cookie.getValue();
            }
        }

        JwtAuthenticationResponse data = refreshToken != null ?
                authenticationService.refreshToken(refreshToken, response) :
                null;

        return data == null ? ResponseEntity.status(401).build() : ResponseEntity.ok(data);
    }

    @PostMapping("/sign-out")
    public ResponseEntity<String> signOut(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) {
        var authHeader = request.getHeader(JwtAuthenticationFilter.HEADER_NAME);
        String accessToken = null;
        if (StringUtils.isNotEmpty(authHeader) && !authHeader.startsWith(JwtAuthenticationFilter.BEARER_PREFIX)) {
            accessToken = authHeader.substring(JwtAuthenticationFilter.BEARER_PREFIX.length());
        }

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return ResponseEntity.status(401).build();
        }

        String refreshToken = null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refreshToken")) {
                refreshToken = cookie.getValue();
            }
        }

        authenticationService.signOut(accessToken, refreshToken, response);
        return ResponseEntity.ok().body("ok");
    }

}
