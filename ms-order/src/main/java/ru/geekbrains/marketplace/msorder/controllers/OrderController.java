package ru.geekbrains.marketplace.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.mscore.models.UserInfo;
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

    @PostMapping("/addProductToOrder/{id}")
    public String addProductToOrder(@RequestHeader String authorization, @PathVariable(value = "id")Long productId){
        System.out.println("Token " + authorization);
        System.out.println("ProductId " + productId);
        UserInfo userInfo =jwtTokenService.parseToken(authorization);
        Long userId = userInfo.getUserId();
        orderService.addToOrder(userId,productId);
        String answer = "OK";
        return answer;
    }

    @GetMapping("/getAllOrder")
    public List<Order> getOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/getIds")
    public OrderDto orderById(@RequestHeader String authorization){
        UserInfo userInfo = jwtTokenService.parseToken(authorization);
        Long userid = userInfo.getUserId();
        return orderService.getOrderListById(userid);
    }
//    Пробую передать лист через Param
    @GetMapping("/deleteFromOrder/{id}")
    public String deleteFromOrder(@RequestHeader String authorization, @PathVariable(value = "id") Long productId){
        UserInfo userInfo =jwtTokenService.parseToken(authorization);
        Long userId = userInfo.getUserId();
        return orderService.deleteProductFromOrder(userId, productId);
    }
}
