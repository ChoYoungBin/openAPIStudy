package com.multi.oauth20server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password(passwordEncoder.encode("1234")).roles("admins", "users")
                .and().withUser("user1").password(passwordEncoder.encode("1234")).roles("users")
                .and().withUser("user2").password(passwordEncoder.encode("1234")).roles("users");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/**", "/login**", "/swagger-ui/**", "/webjars/**", "/v2/**", "/swagger-resources/**")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.formLogin();
    }
}
