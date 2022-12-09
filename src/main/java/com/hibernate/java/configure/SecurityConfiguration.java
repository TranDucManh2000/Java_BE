package com.hibernate.java.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.securityMatcher("/category/**")                       
		.authorizeHttpRequests(authorize -> authorize
			.requestMatchers("").hasRole("ADMIN") 
			.requestMatchers("/admin/**").hasRole("ADMIN")     
			.anyRequest().authenticated()   
		)
		.formLogin();
		 return http.build();
	}
	

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/public/**");
	}
}
