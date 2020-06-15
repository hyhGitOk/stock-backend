/** 
 * Project Name:eurekaServer 
 * File Name:JwtAuthenticationTokenFilter.java 
 * Package Name:com.hyh 
 * Date:2020年5月8日下午8:41:01 
 * Copyright (c) 2020, 46265559@qq.com All Rights Reserved. 
 * 
 */
package com.hyh.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hyh.utility.JwtProperties;
import com.hyh.utility.JwtTokenUtils;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private JwtTokenUtils jwtTokenUtils;
	private Logger logger = Logger.getLogger(getClass());

	public JwtAuthenticationTokenFilter(JwtTokenUtils jwtTokenUtils) {
		this.jwtTokenUtils = jwtTokenUtils;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		String requestRri = httpServletRequest.getRequestURI();
		if (requestRri.startsWith("/api")) {
			// 获取request token
			String token = null;
			JwtProperties jwtProperties = this.jwtTokenUtils.getJwtProperties();
			String bearerToken = httpServletRequest.getHeader(jwtProperties.getHeader());
			if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getTokenStartWith())) {
				token = bearerToken.substring(jwtProperties.getTokenStartWith().length());
			}

			if (StringUtils.hasText(token) && jwtTokenUtils.validateToken(token)) {
				Authentication authentication = jwtTokenUtils.getAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				logger.debug("set Authentication to security context for '{" + authentication.getName() + "}', uri: {"
						+ requestRri + "}");
			} else {
				httpServletRequest.getRequestDispatcher("/token/error").forward(httpServletRequest,
						httpServletResponse);
			}
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}