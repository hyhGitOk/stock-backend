/** 
 * Project Name:eurekaServer 
 * File Name:AuthController2.java 
 * Package Name:com.hyh 
 * Date:2020年5月8日下午8:44:03 
 * Copyright (c) 2020, 46265559@qq.com All Rights Reserved. 
 * 
 */
package com.hyh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.entity.TUser;
import com.hyh.service.UserService;
import com.hyh.utility.JwtTokenUtils;

@RestController
@RequestMapping("/")
public class AuthController {

	private final JwtTokenUtils jwtTokenUtils;

	@Autowired
	private UserService userService;

	public AuthController(JwtTokenUtils jwtTokenUtils) {
		this.jwtTokenUtils = jwtTokenUtils;
	}

	/**
	 * Find user by id
	 * 
	 * @param id user id
	 * @return ResponseEntity<TUser>
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<Object> login(@RequestParam("email") String email,
			@RequestParam("password") String password) {

		TUser user = userService.findByEmailPwd(email, password);
		if (user == null) {
			return new ResponseEntity<Object>("Email or password is invalid.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user.getEmail());
		map.put("password", user.getPassword());
		String token = jwtTokenUtils.getJwtProperties().getTokenStartWith() + jwtTokenUtils.createToken(map);

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("userObj", user);
		resMap.put("token", token);
		return ResponseEntity.ok(resMap);
	}

	@RequestMapping(value = "/token/error", method = RequestMethod.GET)
	public ResponseEntity<String> tokenError() {
		return new ResponseEntity<String>("token is invalid.", HttpStatus.UNAUTHORIZED);
	}
}