package com.profuturo.edocta.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;

@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig {

	@Value("${rest.url.api.user}")
	private String user;
	@Value("${rest.url.api.pass}")
	private String pass;

	@Bean
	public ErrorDecoder errorDecoder() {
		return new FeignCustomErrors();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(user, pass);
	}
}
