package ru.geekbrains.marketplace.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.marketplace.msorder.services.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addProductToOrder/{id}")
    public String addProduct(@PathVariable(value = "id") String s){
        String answer = s + " цена + 100500";
        System.out.println("Testing feign client + text: " + s);
        return answer;
    }

    @GetMapping("/getOrder")
    public String getOrder(HttpServletRequest httpServletRequest){
        String test = orderService.check(httpServletRequest);
        System.out.println("Hello " +  httpServletRequest.getContentType());
        return test;
    }
}
