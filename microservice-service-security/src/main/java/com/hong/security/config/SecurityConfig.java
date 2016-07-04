package com.hong.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by caihongwei on 16/6/24 下午3:22.
 * TODO 参考 http://laodaobazi.iteye.com/blog/1485734
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource datasource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("123123").roles("USER");

        // TODO
        String usersByUsernameQuery = "select * from user where username = ?";
        String authoritiesByUsernameQuery = "select username,authority from authorities where username = ?";
        String groupAuthoritiesByUsername = "select" +
                "   g.id, g.group_name, ga.authority" +
                "   from" +
                "    groups g, group_members gm, group_authorities ga" +
                "   where" +
                "    gm.username = ? and g.id = ga.group_id and g.id = gm.group_id";
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .withDefaultSchema()
                .usersByUsernameQuery("")
                .authoritiesByUsernameQuery("")
                .groupAuthoritiesByUsername("")
                .rolePrefix("ROLE_");
//                .passwordEncoder(new Md5PasswordEncoder());
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
