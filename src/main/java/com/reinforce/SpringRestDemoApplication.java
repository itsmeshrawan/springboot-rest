package com.reinforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@RestController
public class SpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello World!";
	}

	//	Configuration for Swagger
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30).select()
				.apis(RequestHandlerSelectors.basePackage("com.reinforce.controller")).build();
	}

}
