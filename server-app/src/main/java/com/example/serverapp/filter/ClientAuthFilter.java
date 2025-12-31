package com.example.serverapp.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.serverapp.config.ClientCredentialValidation;

@Component
public class ClientAuthFilter extends OncePerRequestFilter {

    private final ClientCredentialValidation credentialValidation;

    public ClientAuthFilter(ClientCredentialValidation credentialValidation) {
        this.credentialValidation = credentialValidation;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String uri = request.getRequestURI();

        if (uri.startsWith("/swagger-ui")
                || uri.startsWith("/v3/api-docs")
                || uri.startsWith("/swagger-ui.html")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!uri.startsWith("/server/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = authHeader.substring(7).trim();
        String[] parts = token.split(":");

        if (parts.length != 2 ||
                !credentialValidation.isValid(parts[0], parts[1])) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
