/** 
 * Project Name:eurekaServer 
 * File Name:WebSecurityConfig.java 
 * Package Name:com.hyh 
 * Date:2020年5月14日下午3:57:04 
 * Copyright (c) 2020, 46265559@qq.com All Rights Reserved. 
 * 
 */
package com.hyh.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 高版本的丢弃了
	 * 
	 * security: basic: enabled: true
	 * 
	 * 配置，应该使用以下方式开启
	 *
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
		http.csrf().disable();
		http.cors();
		//remove basic auth to validate bearer
		//http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
}