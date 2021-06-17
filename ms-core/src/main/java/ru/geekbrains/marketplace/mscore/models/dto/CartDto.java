package ru.geekbrains.marketplace.mscore.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {

    private Long userId;

    private List<CartItemDto> cartItems;

    private Integer totalPrice;

}
