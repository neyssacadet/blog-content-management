/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author 18437
 */
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled =true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
     auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select email,password,enabled from account where email = ?")
        .authoritiesByUsernameQuery("select email,authorityName from authority where email = ?");
    }
     
     @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    
    private static final String[] WHITELIST = {
        "/register/**",
        
        "/h2-console/**",
        "/"
            
    }; 
    
   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {*/
     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(WHITELIST).permitAll()
                // permit everyone to view articles (method GET)
                .antMatchers(HttpMethod.GET,"/articles/*").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/articles/{id}/delete").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll();
        
        // login handling 
        http
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/", true)
                    .failureUrl("/login?error")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .and()
                    .httpBasic();
                
       
        //can be removed if not using h2-console
        http.csrf().disable();
        http.headers().frameOptions().disable();
        
       
    }
}