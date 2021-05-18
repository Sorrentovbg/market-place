package ru.geekbrains.marketplace.eurekafeignclient.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ms-order")
public interface OrderClientFeign {

    @PostMapping("/addProduct")
    String addProduct(String s);
}
