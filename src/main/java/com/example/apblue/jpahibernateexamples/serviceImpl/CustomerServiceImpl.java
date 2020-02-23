package com.example.apblue.jpahibernateexamples.serviceImpl;

import com.example.apblue.jpahibernateexamples.service.CustomerService;
import com.example.apblue.jpahibernateexamples.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
}
