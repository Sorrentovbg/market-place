package ru.geekbrains.marketplace.msproduct.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.eurekafeignclient.order.OrderClientFeign;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msproduct.models.Product;
import ru.geekbrains.marketplace.msproduct.models.specification.ProductSpecifications;
import ru.geekbrains.marketplace.msproduct.services.ProductService;

import java.security.Principal;
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

//    @GetMapping("/getProduct")
//    public Page<ProductDto> getAllProduct(
//            @RequestParam MultiValueMap<String, String> params,
//            @RequestParam(name = "p", defaultValue = "1") Integer page){
//        int size = 5;
//        return productService.getAllProduct(ProductSpecifications.build(params), page - 1,size);
//    }

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
    public String addProduct(@RequestHeader String authorization,@PathVariable(value = "id")Long productId){
        System.out.println("AddProduct ms-product");
        System.out.println("Token " + authorization);
        System.out.println("productId " + productId);
        String answer = orderClientFeign.addProductToOrder(authorization,productId);
        return answer;
    }

    @GetMapping("/getIds")
        public List<ProductDto> getProductIds(@RequestParam List<Long> ids){
        System.out.println("Method getProductIds in OrderController = " + ids.size());
            return productService.findProductByIds(ids);
    }
}

