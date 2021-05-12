package ru.geekbrains.marketplace.mscore.models.dto;

import lombok.Data;

@Data
public class SignUpRequestDto {

    private String login;

    private String password;
}
