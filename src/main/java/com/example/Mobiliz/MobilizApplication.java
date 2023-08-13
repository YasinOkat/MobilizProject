package com.example.Mobiliz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.Mobiliz")
public class MobilizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilizApplication.class, args);
	}
}
