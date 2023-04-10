package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.model.InsufficientBalance;
import com.model.TransactionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.InsufficientBalance;
import com.model.TransactionService;
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})
public class BankingDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(BankingDemoApplication.class, args);
		TransactionService service = context.getBean("transactionService",TransactionService.class);
		try {
			service.moneyTransfer(200,100, 1000);
		} catch (InsufficientBalance e) {
			e.printStackTrace();
		}
	}
}
