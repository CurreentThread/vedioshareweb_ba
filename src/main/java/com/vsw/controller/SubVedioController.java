package com.vsw.controller;


import com.vsw.common.util.CommonUtil;
import com.vsw.domain.Drama;
import com.vsw.service.SubVedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin//跨域代理,每个controller都要写
@RequestMapping("/subvedio")
public class SubVedioController {
    @Autowired
    private SubVedioService subVedioService;


    @RequestMapping("/getAllUrl/{each}/{vedioId}")
    public Object getAllUrl(@PathVariable Integer each,@PathVariable Integer vedioId) {
        Object subvedios = new ArrayList<>();


        subvedios = subVedioService.getAllDramas(each,vedioId);

        return subvedios;

    }


}
