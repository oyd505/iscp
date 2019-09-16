package com.island.iscp.authserver;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * 配置内存登录用户验证
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin")
				.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin")).roles("test");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth/**").permitAll().and().authorizeRequests().anyRequest()
				.authenticated().and().formLogin().and().csrf().disable();
	}

}
