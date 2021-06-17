package ru.geekbrains.marketplace.eurekafeignclient.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "ms-order")
public interface OrderClientFeign {

    @PostMapping("/addProductToOrder/{id}")
    String addProductToOrder(@RequestHeader String authorization, @PathVariable(value = "id")Long productId);


    @PostMapping("/marketplace/v1/cart/addToCart/{id}")
    String addProductToCart(@RequestHeader String authorization,
                            @PathVariable(name = "id") Long productId,
                            @RequestParam(name = "count", defaultValue = "1") int count);
}
