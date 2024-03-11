package com.ohgiraffers.userservice.vo;

import lombok.Data;

import java.util.List;


/**
 *  각 도메인 끼리 통신을 하고 조회된 결곽가 있다면 이러한 VO(도메인별 중간 객체)에 담는다.
 */
@Data
public class ResponseOrder {
    private String orderDate;
    private String orderTime;

    private List<OrderMenuVO> orderMenus;
}
