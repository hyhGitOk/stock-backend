/** 
 * Project Name:eurekaServer 
 * File Name:JwtTokenUtils.java 
 * Package Name:com.hyh 
 * Date:2020年5月8日下午8:39:54 
 * Copyright (c) 2020, 46265559@qq.com All Rights Reserved. 
 * 
 */
package com.hyh.utility;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;

@Component
public class JwtTokenUtils implements InitializingBean {

	private JwtProperties jwtProperties;

	private static final String AUTHORITIES_KEY = "auth";
	private byte[] keyBytes;
	private Logger logger = Logger.getLogger(getClass());

	public JwtTokenUtils(JwtProperties jwtProperties) {
		this.jwtProperties = jwtProperties;
	}

	@Override
	public void afterPropertiesSet() {
		this.keyBytes = Decoders.BASE64.decode(jwtProperties.getBase64Secret());
	}

	public String createToken(Map<String, Object> claims) {
		return Jwts.builder().claim(AUTHORITIES_KEY, claims).setId(UUID.randomUUID().toString()).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtProperties.getTokenValidityInSeconds()))
				.compressWith(CompressionCodecs.DEFLATE).signWith(SignatureAlgorithm.HS512, keyBytes).compact();
	}

	public JwtProperties getJwtProperties() {
		return jwtProperties;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parser().setSigningKey(keyBytes).parseClaimsJws(token).getBody();

		Collection<? extends GrantedAuthority> authorities = Arrays
				.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		HashMap map = (HashMap) claims.get(AUTHORITIES_KEY);

		User principal = new User(map.get("user").toString(), map.get("password").toString(), authorities);

		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(keyBytes).parseClaimsJws(authToken);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			logger.info("Invalid JWT signature.");
			e.printStackTrace();
		} catch (ExpiredJwtException e) {
			logger.info("Expired JWT token.");
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			logger.info("Unsupported JWT token.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.info("JWT token compact of handler are invalid.");
			e.printStackTrace();
		}
		return false;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(keyBytes).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
}