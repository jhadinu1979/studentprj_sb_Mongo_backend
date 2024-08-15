package com.springmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class SpringMongoPrjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoPrjApplication.class, args);
	}

}
