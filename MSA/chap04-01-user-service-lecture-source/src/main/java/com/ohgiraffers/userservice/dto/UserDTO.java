package com.ohgiraffers.userservice.dto;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private java.util.Date createdAt;

    private String encryptedPwd;

    /* 설명. FeignClient 이후 추가 */
    private List<ResponseOrder> orders;
}
