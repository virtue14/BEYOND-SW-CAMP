package com.ohgiraffers.userservice.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestLogin {
    private String email;
    private String password;
}
