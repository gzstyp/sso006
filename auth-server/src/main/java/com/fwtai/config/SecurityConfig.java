package com.fwtai.config;

import com.fwtai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(final WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/login.html","/css/**","/js/**","/images/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception{
        http.requestMatchers()
            .antMatchers("/login")
            .antMatchers("/oauth/authorize")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/login")
            .permitAll()
            .and()
            .csrf().disable();
    }

    // 重写 configure 方法，只不过这次我们不是基于内存，也不是基于 JdbcUserDetailsManager，而是使用自定义的 UserService
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }
}