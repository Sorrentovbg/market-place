//package ru.geekbrains.marketplace.eurekafeignclient.order;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequiredArgsConstructor
//public class OrderControllerFeign {
//
//    @Autowired
//    OrderClientFeign orderClientFeign;
//
//
//    @PostMapping("/feignAddProduct")
//    public String feignAddProduct(String s){
//        System.out.println(orderClientFeign.getClass().getName());
//        System.out.println("RestController OrderControllerFeign");
//        System.out.println("String s = " + s);
//        return orderClientFeign.addProduct(s);
//    }
//}
