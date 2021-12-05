package com.stock.products.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void ConfigAuthentaction(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(dataSource)
		.usersByUsernameQuery(" select username,password,enable from users where username= ?")
		.authoritiesByUsernameQuery(" select username ,role from users where username=?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
			http.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.permitAll()
			.and()
			.logout()
			.permitAll();
		
	}
	
}
