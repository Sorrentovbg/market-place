package ru.geekbrains.marketplace.mscore.exceptions;

public class InvalidTokenException extends RuntimeException {
    public void printException(){
        System.out.println("Ошибка токена");
    }
}
