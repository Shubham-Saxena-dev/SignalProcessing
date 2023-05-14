package com.db.challenge.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class SimpleHeaderFilter extends OncePerRequestFilter {

    private final String headerName;
    private final String headerValue;

    public SimpleHeaderFilter(@Value("${db.auth}") final String headerName,
                              @Value("${db.secret}") final String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String val = request.getHeader(headerName);
        if (val == null || !val.equals(headerValue)) {
            response.setStatus(401);
            response.getWriter().append("Not authorized");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().startsWith("/api/db/");
    }
}
