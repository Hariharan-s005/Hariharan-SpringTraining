package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class WebProjectApplication {

	public static void main(String[] args) {
        //creates context object of ApplicationContext
		ApplicationContext context = SpringApplication.run(WebProjectApplication.class, args);
	}

}
