package com.novoprojeto.projetoooO.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

	@Configuration
	public class WebSecurity extends WebSecurityConfigurerAdapter {
	    
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
			http.headers().frameOptions().sameOrigin();
	        http.csrf()
			        .disable()
			        .authorizeRequests()
			        .antMatchers("/h2-console**").permitAll()
			        .antMatchers("/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .httpBasic()
	                .and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                ;
	    }
		
	}

