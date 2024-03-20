package com.ohgiraffers.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/* 설명. 이번에는 유레카 서버를 chap01-eureka-server 예제의 jar로 실행해 보자. */

/* 설명. 추가된 dependency들
 *  1. Eureka Discovery Client
 *  2. Spring Boot DevTools
 *  3. Lombok
 *  4. Spring Web
 *  5. Spring Data JPA
 *  6. MariaDB Driver
 *
 *  7. modelmapper
 *  8. Spring Security
 * */

/* 설명. 구동 후 /health_check 해볼 것 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Chap0401UserServiceLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0401UserServiceLectureSourceApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
