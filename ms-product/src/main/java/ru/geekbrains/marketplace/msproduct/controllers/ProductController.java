package ru.geekbrains.marketplace.msproduct.controllers;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.eurekafeignclient.order.OrderClientFeign;
import ru.geekbrains.marketplace.eurekafeignclient.order.OrderControllerFeign;
import ru.geekbrains.marketplace.msproduct.models.Product;
import ru.geekbrains.marketplace.msproduct.services.ProductService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    OrderControllerFeign orderControllerFeign;

    @Autowired
    OrderClientFeign orderClientFeign;

    @Autowired
    ProductService productService;



//    @RequestMapping("/getProduct")
//    public Page<Product> getAllProduct(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size){
//        return productService.getAllProductNot(page - 1,size);
//    }

    @RequestMapping("/getProduct")
    @PreAuthorize("permitAll()")
    public List<Product> getAllProduct(){
    return productService.getAllProduct();
    }

    @PostMapping("/addProduct")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product){
        System.out.println("Add product");
        productService.addProduct(product);
    }

    @GetMapping("/get/{id}")
    public String getProductById(@PathVariable Long id, Principal principal){
        Optional<Product> product = productService.getProductById(id);
        return "Наименование: " + product.get().getProductName() + " Цена = " + product.get().getProduct_price();
    }

    @PostMapping("/addProductToOrder/{id}")
    public String addProduct(@PathVariable(value = "id")String s){
        System.out.println("AddProduct ms-product");
        String answer = orderClientFeign.addProduct(s);
        return answer;
    }
}

