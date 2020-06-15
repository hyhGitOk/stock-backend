/** 
 * Project Name:zuulServer 
 * File Name:JwtUtil.java 
 * Package Name:com.hyh.utility 
 * Date:2020年5月8日下午5:24:11 
 * Copyright (c) 2020, chenzhou1025@126.com All Rights Reserved. 
 * 
 */
package com.hyh.utility;

import java.util.Date;
import java.util.HashMap;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

/**
 * @author selinahuang
 *
 */
public class JwtUtil {
	/**
	 * one day for dev, 30 min for prod
	 */
	private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

	/**
	 * token
	 */
	private static final String TOKEN_SECRET = "hyhspring01";

	/**
	 * create token.
	 * 
	 * @param username
	 * @param userId
	 * @return
	 */
	public static String createToken(String username, String userId) {

		Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

		HashMap<String, Object> header = new HashMap<>(2);
		header.put("typ", "JWT");
		header.put("alg", "HS256");

		return JWT.create().withHeader(header).withClaim("loginName", username).withClaim("userId", userId)
				.withExpiresAt(date).sign(algorithm);
	}

	public static boolean checkToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			JWTVerifier verifier = JWT.require(algorithm).build();
			verifier.verify(token);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		} catch (JWTVerificationException e) {
			return false;
		}

	}
}