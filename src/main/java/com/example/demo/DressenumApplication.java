package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Dress Enum",
				version = "1.0.0",
				description = "This project is used to implement dress using enum",
				termsOfService = "Copyright@2023",
				contact = @Contact(
						name = "Manjiri Chandure",
						email = "chanduremanjiri@gmail.com"
				),
				license = @License(
						name = "license",
						url = "/dresses"
				)
		)
)
@SpringBootApplication
public class DressenumApplication {

	public static void main(String[] args) {
		SpringApplication.run(DressenumApplication.class, args);
	}

}
