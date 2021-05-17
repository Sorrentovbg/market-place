package ru.geekbrains.marketplace.mscore.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String title;

    private int price;
}
