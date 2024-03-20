package com.ohgiraffers.userservice.vo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseUser {
    private String email;
    private String name;
    private String userId;

    /* 설명. FeignClient 이후 추가 */
    private List<ResponseOrder> orders;
}
