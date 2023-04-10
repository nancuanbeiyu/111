package com.security.demos.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userdataService;


    //自定义用户登录界面
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")//定义登录页
                .loginProcessingUrl("/ww/wed")//登录访问路径
                .defaultSuccessUrl("/index.html").permitAll()//登录成功之后，跳转路径
                .and().authorizeRequests()
                .antMatchers("/","/hello.html").permitAll()//设置可以直接访问
                .anyRequest().authenticated()
                .and().cors().disable();
    }
}
