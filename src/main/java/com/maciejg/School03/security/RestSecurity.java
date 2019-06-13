package com.maciejg.School03.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class RestSecurity extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest()
		.permitAll() 
		.and()
		.cors()
		.and()
		.csrf()
		.disable(); 
	}
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "OPTIONS", "PUT")
        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers");
	}
}