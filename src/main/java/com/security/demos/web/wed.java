package com.security.demos.web;

import com.security.demos.dao.account;
import com.security.demos.seriver.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@Controller
public class wed  {

@Autowired
private user U;

@GetMapping("/wed")
    public String  get(){
    System.out.println(U.selectList().size());
    return "hello.html";

    }


}
