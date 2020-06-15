package com.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean registration(JwtAuthenticationTokenFilter filter) {
//		FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//		registration.setEnabled(true);
//		//registration.addUrlPatterns("/api/*");
//		return registration;
//	}
}
