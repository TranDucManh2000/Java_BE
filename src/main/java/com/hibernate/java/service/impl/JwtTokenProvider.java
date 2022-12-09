package com.hibernate.java.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	private final String JWT_SECRET = "lodaaaaaa";

	// Thời gian có hiệu lực của chuỗi jwt
	private final long JWT_EXPIRATION = 604800000L;

	// Tạo ra jwt từ thông tin user
	public String generateToken(String userKey) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
		// Tạo chuỗi json web token từ id của user.
		return Jwts.builder().claim("roles", "USER").setSubject(userKey).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	// Lấy thông tin user từ jwt
	public Claims getUserIdFromJWT(String token) {
		String[] parts = token.split(" ");
		Jws<Claims> jws = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(parts[1]);
		return jws.getBody();
	}

}
