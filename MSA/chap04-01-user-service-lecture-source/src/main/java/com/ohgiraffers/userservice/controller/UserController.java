package com.ohgiraffers.userservice.controller;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.service.UserService;
import com.ohgiraffers.userservice.vo.Greeting;
import com.ohgiraffers.userservice.vo.RequestUser;
import com.ohgiraffers.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

/* 설명. gateway에 RewritePath filter 추가 후 */
@RequestMapping("/")

/* 설명. gateway 추가 후 */
//@RequestMapping("/user-service")            // gateway에 필터 추가하면 다시 /로 바꾼다.
public class UserController {
    private Environment env;
    private Greeting greeting;

    private UserService userService;

    @Autowired
    public UserController(Environment env, Greeting greeting, UserService userService) {
        this.env = env;
        this.greeting = greeting;
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service" + env.getProperty("local.server.port")
//                + ", port(local.server.port)=" + env.getProperty("server.port");

                /* 설명. config 서버 연동 후 */
                + ", port(local.server.port)=" + env.getProperty("server.port")
                + ", token secret=" + env.getProperty("token.secret")
                + ", token expiration time=" + env.getProperty("token.expiration_time")
                + ", test=" + env.getProperty("test");
    }

    @GetMapping("/welcome")
    public String welcome() {
//        return env.getProperty("greeting.message");
        return greeting.getMessage();
    }

    /* 설명. 로그인 이전 */
    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDTO userDTO = mapper.map(user, UserDTO.class);
        userService.createUser(userDTO);

        ResponseUser responseUser = mapper.map(userDTO, ResponseUser.class);

//        return new ResponseEntity(HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUser(@PathVariable("userId") String userId) {
        UserDTO userDTO = userService.getUserByUserId(userId);

        ResponseUser returnValue = new ModelMapper().map(userDTO, ResponseUser.class);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

}
