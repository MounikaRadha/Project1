package com.m0wn1la.app2.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HomeController {
    @RequestMapping
    public String home1(){
        return " welcome to the app,i am from "+Thread.currentThread().getName();
    }

}
