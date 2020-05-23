package com.springboot.productdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@ComponentScan(basePackages="com.springboot.productdemo.web")
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).
//		withUser("poulami").password("pass").roles("ADMIN");
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").permitAll()
		.antMatchers("/**").permitAll()
		.antMatchers("/home").permitAll()
		.and().formLogin()//.loginPage("/login").defaultSuccessUrl("/welcome").loginProcessingUrl("/login")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/home")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.clearAuthentication(true);
		//.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//.loginPage("/login").defaultSuccessUrl("/welcome")
		//.failureUrl("/accessdenied") .and().logout().logoutSuccessUrl("/logout");

	}

}
