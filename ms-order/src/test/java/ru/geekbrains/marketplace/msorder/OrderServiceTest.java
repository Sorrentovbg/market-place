package ru.geekbrains.marketplace.msorder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.marketplace.mscore.models.dto.OrderDto;
import ru.geekbrains.marketplace.msorder.models.Order;
import ru.geekbrains.marketplace.msorder.models.OrderItem;
import ru.geekbrains.marketplace.msorder.models.Status;
import ru.geekbrains.marketplace.msorder.repository.OrderRepository;
import ru.geekbrains.marketplace.msorder.services.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void getAllOrderTest(){
        List<Order> demoListOrder = new ArrayList<>();

        LocalDateTime today = LocalDateTime.now();

        Order demoOrderOne = new Order();
        demoOrderOne.setId(1L);
        demoOrderOne.setUserId(1L);
        demoOrderOne.setCreatedAt(today);
        demoOrderOne.setUpdatedAt(today);
        demoOrderOne.setTotalPrice(20000);
        demoOrderOne.setStatus(new Status());
        demoOrderOne.getStatus().setStatus("not paid");


        Order demoOrderTwo = new Order();
        demoOrderTwo.setId(2L);
        demoOrderTwo.setUserId(1L);
        demoOrderTwo.setCreatedAt(today);
        demoOrderTwo.setUpdatedAt(today);
        demoOrderTwo.setTotalPrice(25000);
        demoOrderTwo.setStatus(new Status());
        demoOrderTwo.getStatus().setStatus("notPaid");

        demoListOrder.add(demoOrderOne);
        demoListOrder.add(demoOrderTwo);


        Mockito
                .doReturn(demoListOrder)
                .when(orderRepository)
                .findAllByUserId(1L);

        List<OrderDto> resultList = orderService.getAllOrder(1L);

        assertEquals(2, resultList.size());
        assertEquals(1L, resultList.get(0).getUserId());

    }

    @Test
    public void getOrderById(){
        List<Order> demoListOrder = new ArrayList<>();
        List<OrderItem> demoListOrderItem = new ArrayList<>();

        LocalDateTime today = LocalDateTime.now();

        OrderItem demoOrderItem = new OrderItem();
        demoOrderItem.setId(1L);
        demoOrderItem.setProductId(1L);
        demoOrderItem.setProductName("Телефон");
        demoOrderItem.setPricePerProduct(2500);
        demoOrderItem.setCountProduct(1);
        demoOrderItem.setTotalPriceProduct(2500);

        demoListOrderItem.add(demoOrderItem);

        Order demoOrderOne = new Order();
        demoOrderOne.setId(1L);
        demoOrderOne.setUserId(2L);
        demoOrderOne.setCreatedAt(today);
        demoOrderOne.setUpdatedAt(today);
        demoOrderOne.setTotalPrice(20000);
        demoOrderOne.setStatus(new Status());
        demoOrderOne.getStatus().setStatus("not paid");


        Order demoOrderTwo = new Order();
        demoOrderTwo.setId(2L);
        demoOrderTwo.setUserId(1L);
        demoOrderTwo.setCreatedAt(today);
        demoOrderTwo.setUpdatedAt(today);
        demoOrderTwo.setTotalPrice(25000);
        demoOrderTwo.setStatus(new Status());
        demoOrderTwo.getStatus().setStatus("notPaid");

        demoListOrder.add(demoOrderOne);
        demoListOrder.add(demoOrderTwo);

        Mockito
                .doReturn(demoListOrder.get(0))
                .when(orderRepository)
                .findOrderByUserIdAndId(1L,2L);

        Order requestOrder = orderService.getOrderById(1L,2L);

        assertEquals(1L, requestOrder.getId());
        assertEquals(2L, requestOrder.getUserId());

    }


}
