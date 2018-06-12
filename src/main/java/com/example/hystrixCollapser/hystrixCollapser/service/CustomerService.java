package com.example.hystrixCollapser.hystrixCollapser.service;

import com.example.hystrixCollapser.hystrixCollapser.model.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @HystrixCollapser(
            collapserKey = "getCustomerByIds",
            batchMethod = "getCustomerByIds",
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL
    )
    public Future<Customer> getCustomerById(Long id){
        throw new RuntimeException("This method body should not be executed");
    }

    @HystrixCommand
    public List<Customer> getCustomerByIds(List<Long> ids){
        List<Customer> customers = new ArrayList<>();
        customers = ids.stream().map(id -> new Customer(id, "Customer"+id)).collect(Collectors.toList());
        System.out.println(ids);
        return customers;
    }
}
