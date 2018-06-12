package com.example.hystrixCollapser.hystrixCollapser;

import com.example.hystrixCollapser.hystrixCollapser.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableHystrix
public class HystrixCollapserApplication{

	public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(HystrixCollapserApplication.class, args);
        CustomerService customerService = (CustomerService) ctx.getBean("customerService");

        for(Long i = 0L; i < 10; i++){
		    customerService.getCustomerById(i);
        }
	}
}
