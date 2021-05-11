package ru.geekbrains.marketplace.msproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.geekbrains.marketplace")
public class MsProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductApplication.class, args);
	}
}