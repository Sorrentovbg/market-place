package ru.geekbrains.marketplace.mscore.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemDto {

    private Long productId;

    private String productName;

    private int productPrice;

    private int countProduct;

}
