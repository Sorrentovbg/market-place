package ru.geekbrains.marketplace.eurekafeignclient.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@FeignClient("ms-product")
public interface ProductClientFeign {

    @RequestMapping("/getProduct")
    List<?> getProduct();

    @GetMapping("/get/{id}")
    String get(@PathVariable Long id, Principal principal);
}
