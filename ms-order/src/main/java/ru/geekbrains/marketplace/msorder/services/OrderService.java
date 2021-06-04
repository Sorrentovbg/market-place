package ru.geekbrains.marketplace.msorder.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.marketplace.mscore.models.dto.OrderDto;

import ru.geekbrains.marketplace.msorder.models.*;
import ru.geekbrains.marketplace.msorder.repository.OrderRepository;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;


    private final ModelMapper modelMapper = new ModelMapper();


    public List<OrderDto> getAllOrder(Long userid) {
        return orderRepository.findAllByUserId(userid).stream().map(this::toOrder).collect(Collectors.toList());
    }

    @Transactional
    public String createOrder(Long userId) {
        Cart cart = cartService.getCartToOrder(userId);
        List<OrderItem> orderItems = cart.getCartItems().stream().map(this::toOrderItem).collect(Collectors.toList());
        Order order = modelMapper.map(cart, Order.class);
        order.setOrderItems(orderItems);
        order.setStatus(new Status());
        order.getStatus().setId(1L);
        order.setId(0L);
        orderRepository.save(order);
        cartService.clearCart(userId);
        return "Ваш заказ создан";
    }

    public Order getOrderById(Long userID, Long orderId){
        return orderRepository.findOrderByUserIdAndId(userID, orderId);
    }

    public OrderItem toOrderItem(CartItem cartItem){
        return modelMapper.map(cartItem, OrderItem.class);
    }

    public OrderDto toOrder(Order order){
        return modelMapper.map(order, OrderDto.class);
    }
}
