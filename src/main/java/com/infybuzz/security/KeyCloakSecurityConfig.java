package com.infybuzz.security;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeyCloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter //Abstract-class
{

	//TO use Keycloak as authentication provider
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(keycloakAuthenticationProvider());
	}
	
	
	//Session Management
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		// TODO Auto-generated method stub
		return new RegisterSessionAuthenticationStrategy(
				new SessionRegistryImpl()
				);
	}
	
	//By Default Keycloak will look configuration in JSON file
	//But its in App.prop to take it from here we use this.
	@Bean
	KeycloakConfigResolver keycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		super.configure(http);
		http.authorizeRequests().antMatchers("/contact-us").permitAll()
		.anyRequest() // All public users to access
		.authenticated() // Url Which is accessiable after successful Authentication
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied")
		;
		
	}

}
