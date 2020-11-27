package com.imlty.controller;

import com.imlty.domain.Test;
import com.imlty.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //相当于在这里添加了@Controller和@ResponseBody这两个注解
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping("/findAll")
    public List<Test> findAllTest(){
        return testService.findAllTest();

    }
 
}