package ru.geekbrains.marketplace.eurekafeignclient.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;

import java.util.List;
import java.util.Optional;

@FeignClient("ms-product")
public interface ProductClientFeign {

    @RequestMapping("/marketplace/v1/getProduct")
    List<?> getProduct();

    @GetMapping("/marketplace/v1/product/get/{id}")
    Optional<ProductDto> get(@PathVariable Long id);

    @GetMapping("/marketplace/v1/getIds")
    List<ProductDto> getProductIds(@RequestParam List<Long> ids);
}
