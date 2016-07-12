package com.hong.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        String authoritiesByUsernameQuery = "select a.username, b.authority from user a " +
                " left join Groups_Users gm on a.id=gm.user_id " +
                " left join Groups_Authorities ga on gm.groups_id=ga.groups_id " +
                " right join Authority b on b.id=ga.authority_id" +
                " where a.username=?";
        String groupAuthoritiesByUsername = "select g.id, g.group_name, a.authority" +
                " from Groups g, User u, Groups_Users gm, Groups_Authorities ga, Authority a" +
                " where u.username=? and g.id=gm.groups_id and u.id=gm.user_id" +
                " and g.id=ga.groups_id and ga.authority_id=a.id;";
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .usersByUsernameQuery(usersByUsernameQuery)
                .authoritiesByUsernameQuery(authoritiesByUsernameQuery)
                .groupAuthoritiesByUsername(groupAuthoritiesByUsername)
                .rolePrefix("ROLE_")
                .and()
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
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

    @Bean
    public MyUserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
