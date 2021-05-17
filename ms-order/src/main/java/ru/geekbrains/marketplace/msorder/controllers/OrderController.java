package ru.geekbrains.marketplace.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    @PostMapping("/addProduct")
    public String addProduct(String s){
        String answer = s + " цена + 100500";
        System.out.println("Testing feign client + text: " + s);
        return answer;
    }
}
