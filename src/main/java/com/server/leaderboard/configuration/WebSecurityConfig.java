package com.server.leaderboard.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// permit all not secure
		http
				.authorizeRequests(authorizeRequests ->
						authorizeRequests
								.anyRequest().permitAll() //
				)
				.csrf().disable();

		// allow all origins
		http.cors();

		return http.build();
	}





}