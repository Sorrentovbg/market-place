package ru.geekbrains.marketplace.msorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.geekbrains.marketplace.mscore.services.JWTTokenService;
import ru.geekbrains.marketplace.msorder.repository.OrderRepository;
import ru.geekbrains.marketplace.msorder.repository.StatusRepository;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    JWTTokenService jwtTokenService;

//    Просто проверяю
    public String check(HttpServletRequest httpServletRequest){
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        System.out.println(httpServletRequest.getContextPath());
        return authorizationHeader;
    }
}
