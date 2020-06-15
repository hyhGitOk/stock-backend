/** 
 * Project Name:eurekaServer 
 * File Name:JwtSecurityProperties.java 
 * Package Name:com.hyh 
 * Date:2020年5月8日下午8:35:10 
 * 
 */
package com.hyh.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProperties {

	@Value("${jwt.header}")
	private String header;

	@Value("${jwt.token-start-with}")
	private String tokenStartWith;

	@Value("${jwt.base64-secret}")
	private String base64Secret;

	@Value("${jwt.token-validity-in-seconds}")
	private Long tokenValidityInSeconds;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBase64Secret() {
		return base64Secret;
	}

	public void setBase64Secret(String base64Secret) {
		this.base64Secret = base64Secret;
	}

	public Long getTokenValidityInSeconds() {
		return tokenValidityInSeconds;
	}

	public void setTokenValidityInSeconds(Long tokenValidityInSeconds) {
		this.tokenValidityInSeconds = tokenValidityInSeconds;
	}

	public void setTokenStartWith(String tokenStartWith) {
		this.tokenStartWith = tokenStartWith;
	}

	/** 返回令牌前缀 */
	public String getTokenStartWith() {
		return tokenStartWith + " ";
	}

}
