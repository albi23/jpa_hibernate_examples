package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.CustomerList;
import com.example.apblue.jpahibernateexamples.service.CustomerListService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customerlist")
public class CustomerListCtrl implements FindAllCtrl<CustomerList> {

    private final CustomerListService customerListService;

    @Autowired
    public CustomerListCtrl(CustomerListService customerListService) {
        this.customerListService = customerListService;
    }


    @Override
    public BaseService<CustomerList> getService() {
        return this.customerListService;
    }

}
