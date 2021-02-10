package org.eclipse.FirstSpringMvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
	InMemoryUserDetailsManager manager = new
	InMemoryUserDetailsManager();
	manager.createUser(User.withDefaultPasswordEncoder().
	username("user").password("user").roles("USER").build());
	return manager;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
	http.authorizeRequests().antMatchers("/login").permitAll();
	http.authorizeRequests().anyRequest().authenticated()
	.and()
	.formLogin().loginPage("/login")
	.and()
	.logout().permitAll();
	}
	
}
