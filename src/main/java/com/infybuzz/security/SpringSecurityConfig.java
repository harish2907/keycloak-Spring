package com.infybuzz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService UserDetailsServiceImpl;

	//SS should know that which implementations We did
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UserDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/", "/login").permitAll().antMatchers("/home") // All public users to access
		.authenticated() // Url Which is accessiable after successful Authentication
		.and()
		.csrf().disable()
		.formLogin() //form based login
		.loginPage("/login")  // action from html file
		.defaultSuccessUrl("/home") //redirect
		.usernameParameter("username").passwordParameter("password")
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
		;
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
