package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Address;
import com.example.apblue.jpahibernateexamples.service.AddressService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/address")
public class AddressCtrl implements FindAllCtrl<Address> {

    private final AddressService addressService;

    @Autowired
    public AddressCtrl(AddressService addressService) {
        this.addressService = addressService;
    }


    @Override
    public BaseService<Address> getService() {
        return this.addressService;
    }

}
