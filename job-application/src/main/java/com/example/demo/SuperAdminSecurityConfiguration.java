package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

import com.example.demo.services.UserService;

@EnableWebSecurity
@Configuration
@Order(1)
public class SuperAdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().and().csrf().disable();

		httpSecurity.antMatcher("/superadmin/**")
					.authorizeRequests()
					.antMatchers("/superadmin/**").access("hasRole('ROLE_SUPER_ADMIN')")
					.and()
					.formLogin().loginPage("/superadmin-panel")
					.loginProcessingUrl("/superadmin/process-login")
					.defaultSuccessUrl("/superadmin-panel/welcome")
					.failureUrl("/superadmin-panel/login?error")
					.usernameParameter("username").passwordParameter("password")
					.and()
					.logout().logoutUrl("/superadmin-panel/process-logout")
					.logoutSuccessUrl("/superadmin-panel/login?logout")
					.deleteCookies("JSESSIONID")
					.invalidateHttpSession(true)
					.and()
					.exceptionHandling().accessDeniedPage("/superadmin-panel/accessDenied");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userService);
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityContextHolderAwareRequestFilter awareRequestFilter() {
	    return new SecurityContextHolderAwareRequestFilter();
	}

	@Bean
	public SecurityContextPersistenceFilter persistenceFilter() {
		return new SecurityContextPersistenceFilter();
	}

}