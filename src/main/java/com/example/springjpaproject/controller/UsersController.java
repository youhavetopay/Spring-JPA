package com.example.springjpaproject.controller;

import com.example.springjpaproject.entity.UsersEntitiy;
import com.example.springjpaproject.repository.UsersRepository;
import com.example.springjpaproject.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity findUser(@PathVariable("userId") String userId){

        Map<String, Object> result = new HashMap<>();

        // 제대로된 응답값 만들기 전까지만 사용하기
        try{
            UsersEntitiy findUserInfo = usersService.findUserInfoByUserId(userId);
            result.put("status", "SUCCESS");
            result.put("result", findUserInfo);
        } catch (Exception e){
            result.put("status", "FAIL");
            result.put("error", e.getMessage());
            e.printStackTrace();
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody Map<String, Object> param){

        Map<String, Object> result = new HashMap<>();

        // 제대로된 응답값 만들기 전까지만 사용하기
        try{
            usersService.saveUser(param);
            result.put("status", "SUCCESS");
            UsersEntitiy findUserInfo = usersService.findUserInfoByUserId(param.get("userId").toString());
            result.put("result", findUserInfo);
        } catch (Exception e){
            result.put("status", "FAIL");
            result.put("error", e.getMessage());
            e.printStackTrace();
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
