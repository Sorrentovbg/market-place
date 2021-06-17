package ru.geekbrains.marketplace.msorder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.marketplace.mscore.models.dto.CartDto;
import ru.geekbrains.marketplace.msorder.models.Cart;
import ru.geekbrains.marketplace.msorder.models.CartItem;
import ru.geekbrains.marketplace.msorder.repository.CartRepository;
import ru.geekbrains.marketplace.msorder.services.CartService;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    private CartService cartService;

    @MockBean
    private CartRepository cartRepository;


    @Test
    public void getPriceTest(){
        CartItem demoCartItemOne = new CartItem(1L, 1L, "Телефон", 2500, 1, 2500);
        CartItem demoCartItemTwo = new CartItem(2L, 1L, "Зарядка", 500, 1, 500);
        List<CartItem> demoList = new ArrayList<>();
        demoList.add(demoCartItemOne);
        demoList.add(demoCartItemTwo);

        int price = cartService.getPrice(demoList);
        assertEquals(3000,price);
    }
    @Test
    public void getCartTest(){
        CartItem demoCartItemOne = new CartItem(1L, 1L, "Телефон", 2500, 1, 2500);
        CartItem demoCartItemTwo = new CartItem(2L, 1L, "Зарядка", 500, 1, 500);
        List<CartItem> demoList = new ArrayList<>();
        demoList.add(demoCartItemOne);
        demoList.add(demoCartItemTwo);
        Cart demoCart = new Cart(1L, 1L, demoList, 3000);

        Mockito
                .doReturn(demoCart)
                .when(cartRepository)
                .findCartByUserId(1L);

        CartDto demoCartDto = cartService.getCart(1L);

        assertEquals(1L, demoCartDto.getUserId());
        assertEquals(demoList.size(), demoCartDto.getCartItems().size());
    }

}
