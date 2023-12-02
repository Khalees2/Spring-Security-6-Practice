package com.practice.springsecurity.security.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            SecretKey mySecretKey = Keys.hmacShaKeyFor("jwt".getBytes(StandardCharsets.UTF_8));

            String jwtToken = Jwts.builder().setIssuer("khalees2").setSubject("JWT Token")
                    .claim("username",authentication.getName())
                    .claim("authorities",authentication.getAuthorities())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + 3000000))
                    .signWith(mySecretKey).compact();
            response.setHeader("Authorization",jwtToken);
        }
        filterChain.doFilter(request,response);
    }
}
