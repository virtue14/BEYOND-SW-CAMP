package com.ohgiraffers.userservice.client;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="swcamp-order-service", url = "localhost:8000")
public interface OrderServiceClient {

    @GetMapping("/order-service/orders/{userId}")
    List<ResponseOrder> getUserOrders(@PathVariable String userId);
}
