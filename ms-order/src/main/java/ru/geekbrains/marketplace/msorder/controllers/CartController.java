package ru.geekbrains.marketplace.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.mscore.models.UserInfo;
import ru.geekbrains.marketplace.mscore.models.dto.CartDto;
import ru.geekbrains.marketplace.mscore.services.JWTTokenService;
import ru.geekbrains.marketplace.msorder.services.CartService;

@RestController
@RequestMapping("/marketplace/v1/cart")
@RequiredArgsConstructor
public class CartController {

    @Autowired
    JWTTokenService jwtTokenService;

    @Autowired
    CartService cartService;



    @PostMapping("/addToCart/{id}")
    public String addProductToCart(@RequestHeader String authorization,
                                   @PathVariable(name = "id") Long productId,
                                   @RequestParam(name = "count", defaultValue = "1") int count){
        UserInfo userInfo = jwtTokenService.parseToken(authorization);
        Long userId = userInfo.getUserId();
        cartService.addToCart(userId, productId, count);
        return "OK";
    }

    @PostMapping("/getCart")
    public CartDto getCart(@RequestHeader String authorization){
        UserInfo userInfo =jwtTokenService.parseToken(authorization);
        Long userId = userInfo.getUserId();
        return cartService.getCart(userId);
    }

    @GetMapping("/delFromCart/{id}")
    public String delFromCart(@RequestHeader String authorization,
                              @PathVariable(name = "id") Long productId){
        UserInfo userInfo =jwtTokenService.parseToken(authorization);
        Long userId = userInfo.getUserId();
        cartService.delFromCart(userId,productId);
        return "Product has deleted";
    }

    @GetMapping("/clearCart")
    public String clearCart(@RequestHeader String authorization){
        Long userId = jwtTokenService.parseToken(authorization).getUserId();
        cartService.clearCart(userId);
        return "Cart has been cleared";
    }


}
