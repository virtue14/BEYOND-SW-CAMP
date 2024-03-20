package com.ohgiraffers.userservice.service;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import com.ohgiraffers.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

//public interface UserService {

/* 설명. 로그인 시 추가 */
public interface UserService extends UserDetailsService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserDetailsByEmail(String userName);


    UserDTO getUserByUserId(String userId);
}
