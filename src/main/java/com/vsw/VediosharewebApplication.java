package com.vsw;

import com.vsw.domain.Vedio;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@SpringBootApplication
@MapperScan(basePackages = "com.vsw.mapper")
@RestController
//@ResponseBody
//@CrossOrigin//跨域代理
public class VediosharewebApplication {

/*
    @RequestMapping("/hello")
    public User logon(){

        User user = new User();
        user.setUsername("changshan");
        user.setPassword("sss");
        return user;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(VediosharewebApplication.class, args);
//
    }
}
