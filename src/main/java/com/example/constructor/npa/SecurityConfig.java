package com.example.constructor.npa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.Arrays;

/**
 * Created by root on 9/6/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests().antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        UserDetails admin = new User("admin", "123"
                , Arrays.asList(new SimpleGrantedAuthority("admin")
                , new SimpleGrantedAuthority("readonly")
                , new SimpleGrantedAuthority("readwrite")));

        UserDetails user1 = new User("user1", "123"
                , Arrays.asList(new SimpleGrantedAuthority("readonly")
                , new SimpleGrantedAuthority("readwrite")));

        UserDetails user2 = new User("user2", "123"
                , Arrays.asList(new SimpleGrantedAuthority("readonly")));

        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(Arrays.asList(admin, user1, user2));
        auth.userDetailsService(userDetailsManager);
    }
}
