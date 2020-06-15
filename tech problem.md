1.spring security is conflict with cors filter
------------------------------------------------------
package com.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	/**
	 * 跨域过滤器
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}
}
---------------------------------------------------------------
这样配置之后，在前台是可以正常访问后台api接口的，在pom.xml中添加spring security之后，前台访问就会报cors错误。

原因是加上security之后，会先触发security的spring security filter chain, 再去调用corsFilter，那么相应的解决办法就是将corsFilter放在spring security filter chain前面。

在WebSecurityConfigurerAdapter的子类的configure(HttpSecurity httpSecurity)方法中加上“httpSecurity.addFilterBefore(corsFilter(), ChannelProcessingFilter.class)”

