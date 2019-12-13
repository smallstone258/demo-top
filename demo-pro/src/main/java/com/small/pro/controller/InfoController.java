package com.small.pro.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {


    @GetMapping(value = "/info/{value}")
    public   String    info(@PathVariable  String   value){

        return  value;
    }

}
