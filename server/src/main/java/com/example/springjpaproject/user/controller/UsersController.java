package com.example.springjpaproject.user.controller;

import com.example.springjpaproject.common.ResponseMessage;
import com.example.springjpaproject.common.StatusEnum;
import com.example.springjpaproject.user.entity.UsersEntitiy;
import com.example.springjpaproject.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UsersController {

  @Autowired
  private UsersService usersService;

  private ResponseMessage responseMessage;
  private HttpHeaders headers = new HttpHeaders();


  @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
  public ResponseEntity findUser(@PathVariable("userId") String userId) {
    headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    responseMessage = new ResponseMessage();

    // 제대로된 응답값 만들기 전까지만 사용하기
    try {
      UsersEntitiy findUserInfo = usersService.findUserInfoByUserId(userId);
      responseMessage.setStatus(StatusEnum.OK);
      responseMessage.setMessage("아이디 조회 성공");
      responseMessage.setData(findUserInfo);

    } catch (Exception e) {
      responseMessage.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
      responseMessage.setMessage("내부 서버 오류");
      responseMessage.setData(e.getMessage());
      e.printStackTrace();
      return new ResponseEntity(responseMessage, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity(responseMessage, headers, HttpStatus.OK);
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public ResponseEntity saveUser(@RequestBody Map<String, Object> param) {

    headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    responseMessage = new ResponseMessage();

    // 제대로된 응답값 만들기 전까지만 사용하기
    try {
      usersService.saveUser(param);
      UsersEntitiy findUserInfo = usersService.findUserInfoByUserId(param.get("userId").toString());
      responseMessage.setStatus(StatusEnum.OK);
      responseMessage.setMessage("저장 성공");
      responseMessage.setData(findUserInfo);
    } catch (Exception e) {
      responseMessage.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
      responseMessage.setMessage("내부 서버 오류");
      responseMessage.setData(e.getMessage());
      e.printStackTrace();
      return new ResponseEntity(responseMessage, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity(responseMessage, headers, HttpStatus.OK);
  }
}
