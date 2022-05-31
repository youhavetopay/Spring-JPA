package com.example.springjpaproject.user.repository;

import com.example.springjpaproject.user.entity.UsersEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntitiy, Integer> {

  UsersEntitiy findUsersEntitiyByUserId(final String userId);

  UsersEntitiy save(UsersEntitiy userInfo);

}
