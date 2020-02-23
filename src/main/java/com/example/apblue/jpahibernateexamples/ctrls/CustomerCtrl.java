package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Customer;
import com.example.apblue.jpahibernateexamples.service.CustomerService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerCtrl implements FindAllCtrl<Customer> {

    private final CustomerService customerService;

    @Autowired
    public CustomerCtrl(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public BaseService<Customer> getService() {
        return this.customerService;
    }

}
