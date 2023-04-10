package com.security.demos.dao;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Data
@Controller
public class account {

    private int id;
    private String account;
    private  String password;
}
