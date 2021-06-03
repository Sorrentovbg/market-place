package ru.geekbrains.marketplace.eurekafeignclient.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

@FeignClient("ms-order")
public interface OrderClientFeign {

    @PostMapping("/addProductToOrder/{id}")
    String addProductToOrder(@RequestHeader String authorization, @PathVariable(value = "id")Long productId);
}
