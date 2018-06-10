package com.example.hystrixCollapser.hystrixCollapser;

import com.example.hystrixCollapser.hystrixCollapser.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HystrixCollapserApplication{

	public static void main(String[] args) {

		SpringApplication.run(HystrixCollapserApplication.class, args);
        CustomerService c = new CustomerService();
		for(Long i = 0L; i < 10; i++){
		    System.out.println(c.getCustomerById(i));
        }
	}
}
