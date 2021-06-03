package ru.geekbrains.marketplace.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.mscore.models.UserInfo;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.mscore.services.JWTTokenService;
import ru.geekbrains.marketplace.msorder.models.Cart;
import ru.geekbrains.marketplace.msorder.services.CartService;

@RestController
@RequestMapping("/marketplace/v1/cart")
@RequiredArgsConstructor
public class CartController {

    @Autowired
    JWTTokenService jwtTokenService;

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart")
    public String addProductToCart(
            @RequestHeader String authorization,
            @RequestBody ProductDto productDto,
            @RequestParam(name = "count", defaultValue = "1") int count){
        System.out.println("Token " + authorization);
        System.out.println("ProductId " + productDto.getProductName());
        UserInfo userInfo =jwtTokenService.parseToken(authorization);
        Long userId = userInfo.getUserId();
        cartService.addToCart(userId, productDto, count);
        String answer = "OK";
        return answer;
    }

    @PostMapping("/getCart")
    public Cart getCart(@RequestHeader String authorization){
        UserInfo userInfo =jwtTokenService.parseToken(authorization);
        Long userId = userInfo.getUserId();
        return cartService.getCart(userId);
    }


}
