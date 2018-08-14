package com.vsw.controller;

import com.vsw.common.config.LoginRequired;
import com.vsw.domain.Vediouser;
import com.vsw.mapper.VediouserMapper;
import com.vsw.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//跨域代理,每个controller都要写
@Slf4j
public class UserContrlloer {

    @Autowired
    private UserService userService;



    @RequestMapping("/login")
    @LoginRequired
    public Vediouser login(@RequestBody  Vediouser vediouser, String accessToken){
        if(vediouser.getUserid()!=null)
            return vediouser;

        Vediouser findOne = userService.login(vediouser);
        return findOne;
    }

    @RequestMapping("/automiclogin")
    @LoginRequired
    public Vediouser automiclogin(@RequestBody  Vediouser vediouser, String accessToken){

        if(vediouser.getUserid()!=null) {
            log.error(vediouser+"");
            return vediouser;
        }
        else
            return null;
    }

}
