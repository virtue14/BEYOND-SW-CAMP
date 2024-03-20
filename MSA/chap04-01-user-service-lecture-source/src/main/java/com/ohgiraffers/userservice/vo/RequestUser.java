package com.ohgiraffers.userservice.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestUser {

    private String email;
    private String name;
    private String pwd;
}
