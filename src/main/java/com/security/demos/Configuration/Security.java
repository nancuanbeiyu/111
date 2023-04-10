package com.security.demos.Configuration;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.security.demos.dao.account;
import com.security.demos.seriver.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/*
配置类
自定义用户账户密码
实现接口UserDetailsService中loadUserByUsername方法
@Service
username 为用户名
There is no PasswordEncoder mapped for the id “null“最简单的解决方式："{bcrypt}" +getPassword的加密

 */
@Controller
public class Security  implements UserDetailsService {

    @Autowired
    private user u;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询账户信息
       account account1 = u.longin(username);

        //账户不存在时，逻辑
        if(account1==null){
              throw new UsernameNotFoundException("没有该账户");
        }
//      给角色设置访问权限
        List<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList("one,ROLE_sale");
        //创建 user 并非 wed文件夹中User 返回
        return new User(account1.getAccount(),"{bcrypt}" +
                new BCryptPasswordEncoder().encode(account1.getPassword()),authorities);

    }
     
}
