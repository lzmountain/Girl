package com.nj.rcxc.controller;

import com.nj.rcxc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Fred on 2018/6/24.
 */

//@Controller
@RestController
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private int age;
//
//    @Value("${content}")
//    private String content;
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello","/say"}, method = RequestMethod.POST)
    public String say(@RequestParam(value = "id",required = false, defaultValue = "10")int id){
        System.out.println("/hello is running");
        //return "Hello Spring Boot! "+cupSize+", "+age+"---"+content;
        return girlProperties.getCupSize()+": "+id;
    }
}
