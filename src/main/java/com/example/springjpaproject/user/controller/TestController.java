package com.example.springjpaproject.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map testMapReturn(){
        Map result = new HashMap<String, Object>();

        result.put("GROUP_NAME","IZONE");

        return result;

    }
}
