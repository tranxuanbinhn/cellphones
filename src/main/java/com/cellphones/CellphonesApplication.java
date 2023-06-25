package com.cellphones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class CellphonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CellphonesApplication.class, args);
	}

}
