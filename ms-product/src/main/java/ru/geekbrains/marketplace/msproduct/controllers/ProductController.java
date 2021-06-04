package ru.geekbrains.marketplace.msproduct.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.eurekafeignclient.order.OrderClientFeign;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msproduct.models.Product;
import ru.geekbrains.marketplace.msproduct.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marketplace/v1/product")
@RequiredArgsConstructor
public class ProductController {


    @Autowired
    OrderClientFeign orderClientFeign;

    @Autowired
    ProductService productService;


    @GetMapping("/getProduct")
    public Page<ProductDto> getAllProduct(
            @RequestParam(name = "p", defaultValue = "1") Integer page){
        int size = 5;
        if(page < 1){
            page = 1;
        }
        return productService.getAllProduct(page ,size);
    }

    @GetMapping("/getSortedProduct")
    public Page<ProductDto> getSortedProduct(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                             @RequestParam(name = "sort", required = false) String sort,
                                             @RequestParam(name = "priceAt", required = false) Integer priceAt,
                                             @RequestParam(name = "priceTo",required = false) Integer priceTo){
        int size = 5;
        if(page < 1){
            page = 1;
        }
        return productService.getSortedProduct(page, sort, size, priceAt,priceTo);
    }

    @PostMapping("/addProduct")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/get/{id}")
    public Optional<ProductDto> getProductById(@PathVariable Long id){
        Optional<ProductDto> product = productService.getProductToCart(id);
        return product;
    }

    @PostMapping("/addToCart/{id}")
    public String addProductToCart(@RequestHeader String authorization,
                                   @PathVariable(name = "id") Long productId,
                                   @RequestParam(name = "count", defaultValue = "1") int count){
        return orderClientFeign.addProductToCart(authorization,productId,count);
    }

    @GetMapping("/getIds")
        public List<ProductDto> getProductIds(@RequestParam List<Long> ids){
            return productService.findProductByIds(ids);
    }
}

