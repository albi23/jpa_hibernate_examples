package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Payment;
import com.example.apblue.jpahibernateexamples.service.PaymentService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payment")
public class PaymentCtrl implements FindAllCtrl<Payment> {

    private final PaymentService paymentService;

    @Autowired
    public PaymentCtrl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @Override
    public BaseService<Payment> getService() {
        return this.paymentService;
    }

}
