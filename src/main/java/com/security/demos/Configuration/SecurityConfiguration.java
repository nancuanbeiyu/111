package com.security.demos.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//开启注解使用
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userdataService;


    //自定义用户登录界面
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //用户没有权限时跳转页面
        http.exceptionHandling().accessDeniedPage("/error.html");
        //用户注销
        http.logout().logoutUrl("/ret").logoutSuccessUrl("/login.html").permitAll();


        //
        http.formLogin()
               // .loginPage("/login.html")//定义登录页
               //  .loginProcessingUrl("/wed")//登录访问路径
                .defaultSuccessUrl("/index.html").permitAll()//登录成功之后，跳转路径
                .and().authorizeRequests()
                //.antMatchers("/","/hello.html").permitAll()//设置可以直接访问
                //设置访问权限,具有admins才可以访问/hello ,单个权限hasAuthority，多个权限hasAnyAuthority
                .antMatchers("/hello.html").hasAnyAuthority("admins","one")
                .anyRequest().authenticated()
                .and().cors().disable();
    }
}
