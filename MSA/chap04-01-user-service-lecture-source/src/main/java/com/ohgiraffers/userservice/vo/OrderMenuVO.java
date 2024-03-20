package com.ohgiraffers.userservice.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderMenuVO {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
