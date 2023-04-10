package com.security.demos.web;

import com.security.demos.dao.account;
import com.security.demos.seriver.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@Controller
public class wed  {

@Autowired
private user U;
//检查用户权限，使用该方法 。格式：“ROLE_XXXX”
@Secured({"ROLE_sale"})
@GetMapping("/wed")
    public String  get(){
    System.out.println(U.selectList().size());
    return "hello.html";

    }
    //进入该方法之前进行验证
    @PreAuthorize("hasAnyAuthority('one')")
    @GetMapping("/wedone")
    public String  getone(){
        System.out.println(U.selectList().size());
        return "index.html";
    }



}
