package com.example.springjpaproject.service;

import com.example.springjpaproject.entity.UsersEntitiy;
import com.example.springjpaproject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersEntitiy findUserInfoByUserId(final String userId){

        final UsersEntitiy userInfo = usersRepository.findUsersEntitiyByUserId(userId);

        return userInfo;
    }

    public void saveUser(Map<String, Object> param){
        UsersEntitiy usersEntitiy = UsersEntitiy.builder()
                .userId(param.get("userId").toString())
                .userName(param.get("userName").toString())
                .build();

        usersRepository.save(usersEntitiy);
    }

}
