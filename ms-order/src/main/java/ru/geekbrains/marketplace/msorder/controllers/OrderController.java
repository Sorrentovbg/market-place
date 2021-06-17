package ru.geekbrains.marketplace.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.mscore.models.dto.OrderDto;
import ru.geekbrains.marketplace.mscore.services.JWTTokenService;
import ru.geekbrains.marketplace.msorder.models.Order;
import ru.geekbrains.marketplace.msorder.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/marketplace/v1/order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    JWTTokenService jwtTokenService;


    @PostMapping("/createOrder")
    public String createOrder(@RequestHeader String authorization){
        Long userId = jwtTokenService.parseToken(authorization).getUserId();
        return orderService.createOrder(userId);
    }


    @GetMapping("/getAllOrder")
    public List<OrderDto> getOrder(@RequestHeader String authorization){
        Long userId = jwtTokenService.parseToken(authorization).getUserId();
        return orderService.getAllOrder(userId);
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@RequestHeader String authorization, @PathVariable(value = "id")Long orderId){
        Long userId = jwtTokenService.parseToken(authorization).getUserId();
        return orderService.getOrderById(userId,orderId);
    }

}
