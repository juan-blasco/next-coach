package com.nextcoach;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nextcoach.converter.DateFormatter;
import com.nextcoach.security.CustomAuthenticationProvider;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class NextCoachApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(NextCoachApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/access").setViewName("access");
	}

	@Bean
	public ConversionService conversionService() {
		FormattingConversionServiceFactoryBean conversion = new FormattingConversionServiceFactoryBean();
		conversion.setFormatters(Collections.singleton(dateFormatter()));
		return conversion.getObject();
	}

	@Bean
	public DateFormatter dateFormatter() {
		return new DateFormatter();
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private CustomAuthenticationProvider authenticationProvider;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(authenticationProvider);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.csrf().disable()
					.authorizeRequests()
					.antMatchers("/h2-console/**", "/login", "/registration").permitAll()
					.anyRequest()
					.fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").and()
					.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and().exceptionHandling()
					.accessDeniedPage("/access?error");
		}
	}

}
