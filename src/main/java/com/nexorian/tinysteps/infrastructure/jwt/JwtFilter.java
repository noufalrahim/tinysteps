package com.nexorian.tinysteps.infrastructure.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/auth/");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            writeError(
                    response,
                    HttpStatus.UNAUTHORIZED,
                    "AUTH_HEADER_MISSING",
                    "Missing or invalid Authorization header"
            );
            return;
        }

        String token = header.substring(7).trim();

        try {
            jwtUtil.isTokenValid(token);

            String userId = jwtUtil.extractUserId(token);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userId,
                            null,
                            Collections.emptyList()
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            writeError(
                    response,
                    HttpStatus.UNAUTHORIZED,
                    "JWT_ERROR",
                    "Invalid JWT token"
            );
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void writeError(
            HttpServletResponse response,
            HttpStatus status,
            String code,
            String message
    ) throws IOException {

        response.setStatus(status.value());
        response.setContentType("application/json");

        response.getWriter().write(
                "{"
                        + "\"status\":" + status.value() + ","
                        + "\"error\":\"" + code + "\","
                        + "\"message\":\"" + message + "\""
                        + "}"
        );
    }
}
