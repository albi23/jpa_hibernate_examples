package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Rental;
import com.example.apblue.jpahibernateexamples.service.RentalService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rental")
public class RentalCtrl implements FindAllCtrl<Rental> {

    private final RentalService rentalService;

    @Autowired
    public RentalCtrl(RentalService rentalService) {
        this.rentalService = rentalService;
    }


    @Override
    public BaseService<Rental> getService() {
        return this.rentalService;
    }

}
