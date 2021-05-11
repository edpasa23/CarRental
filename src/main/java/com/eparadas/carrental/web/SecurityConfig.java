package com.eparadas.carrental.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //agregar mas usuarios y personalizar los usarios que se usaran

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

/*    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws  Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN", "USER")
                .and()
                    .withUser("user")
                    .password("{noop}123")
                .roles("USER");
    }*/

    //restringe las urls de la aplicacion segun el rol
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/editUser/**","/addUser/**","/deleteUser")
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("USER","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/error-layout/403");
    }



}
