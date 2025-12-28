package com.auth_service.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth_service.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	@Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(User user) {
        long expiration = 1000 * 60 * 60 * 10; // 10 hours
        return Jwts.builder()
                 .setSubject(user.getId().toString())
                .claim("role", user.getRole())
                 .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                 .signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes())
                .compact();
    }  

    public Claims getClaims(String token) {
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
}}  
