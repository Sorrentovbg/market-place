//package ru.geekbrains.marketplace.eurekafeignclient.product;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class ProductControllerFeign {
//
//    @Autowired
//    ProductClientFeign productClientFeign;
//
//    @GetMapping("/getProduct")
//    public String getProduct(){
//        String answer = productClientFeign.getProduct().toString();
//        return answer;
//    }
//}
