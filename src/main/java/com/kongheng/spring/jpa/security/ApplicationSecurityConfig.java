package com.kongheng.spring.jpa.security;

import static com.kongheng.spring.jpa.security.ApplicationUserRole.ADMIN;
import static com.kongheng.spring.jpa.security.ApplicationUserRole.ADMIN_TRAINEE;
import static com.kongheng.spring.jpa.security.ApplicationUserRole.STUDENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
        .antMatchers("/api/**").hasAnyRole(STUDENT.name())
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {
    UserDetails annaSmithUser = User.builder()
        .username("annasmith")
        .password(passwordEncoder.encode("password"))
//        .roles(STUDENT.name())
        .authorities(STUDENT.getGrantedAuthorities())
        .build();
    UserDetails lindaUser = User.builder()
        .username("linda")
        .password(passwordEncoder.encode("password"))
//        .roles(ADMIN.name())
        .authorities(ADMIN.getGrantedAuthorities())
        .build();
    UserDetails tomUser = User.builder()
        .username("tom")
        .password(passwordEncoder.encode("password"))
//        .roles(ADMIN_TRAINEE.name())
        .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
        .build();
    return new InMemoryUserDetailsManager(annaSmithUser, lindaUser, tomUser);
  }
}
