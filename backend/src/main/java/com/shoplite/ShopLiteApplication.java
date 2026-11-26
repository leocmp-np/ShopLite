package com.shoplite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication

public class ShopLiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopLiteApplication.class, args);
	}

}
