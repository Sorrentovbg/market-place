package ru.geekbrains.marketplace.msorder.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.geekbrains.marketplace.eurekafeignclient.product.ProductClientFeign;
import ru.geekbrains.marketplace.mscore.models.dto.OrderDto;

import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msorder.models.Order;
import ru.geekbrains.marketplace.msorder.models.Status;
import ru.geekbrains.marketplace.msorder.repository.OrderRepository;



import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductClientFeign productClientFeign;


    private final ModelMapper modelMapper = new ModelMapper();



    public void addToOrder(Long userId, Long productId) {
        Order order = orderRepository.findOrderByUserId(userId);
        if (order != null){
            order.getProductIds().add(productId);
            orderRepository.save(order);
        }else {
            List<Long> productIds = new ArrayList<>();
            productIds.add(productId);
            Order newOrder = new Order(userId,productIds);
            newOrder.getStatus().setId(1L);
            orderRepository.save(newOrder);
        }
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public OrderDto getOrderListById(Long userid) {
        System.out.println("User id = " + userid);
        Order order = orderRepository.findOrderByUserId(userid);
        System.out.println("OrderService order.getProductId() = " + order.getProductIds().size());
        List<ProductDto> productIds = productClientFeign.getProductIds(order.getProductIds());
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        orderDto.setProductIds(productIds);
        return orderDto;

    }

    public String deleteProductFromOrder(Long userId, Long productId) {
        Order order = orderRepository.findOrderByUserId(userId);
        List<Long> productIds = order.getProductIds();
        for (int i = 0; i < productIds.size(); i++){
            if(productIds.get(i).equals(productId)){
                productIds.remove(i);
            }
        }
        order.setProductIds(productIds);
        orderRepository.save(order);
        return "Remove ok";
    }
}
