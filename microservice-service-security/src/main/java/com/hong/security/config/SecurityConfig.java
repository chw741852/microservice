package com.hong.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by caihongwei on 16/6/24 下午3:22.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource datasource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("123123").roles("USER");

        auth.jdbcAuthentication()
                .dataSource(datasource)
                .withDefaultSchema()
                .usersByUsernameQuery("")
                .authoritiesByUsernameQuery("")
                .groupAuthoritiesByUsername("")
                .rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
                .permitAll()
                .and()
                .logout().logoutUrl("/j_spring_security_logout").invalidateHttpSession(true)
                .permitAll();
    }
}
