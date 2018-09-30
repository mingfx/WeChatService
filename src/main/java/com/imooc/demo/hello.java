package com.imooc.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //表示类为controller，可以接受前台发送的请求，进行响应
public class hello {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)//路由，
     public String hello(){
         return "Hello SpringBoot!";
     }
}
