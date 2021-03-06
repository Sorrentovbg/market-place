package ru.geekbrains.marketplace.mscore.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;

    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer totalPrice;

    private String status;
}
