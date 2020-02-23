package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.SalesByStore;
import com.example.apblue.jpahibernateexamples.service.SalesByStoreService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/salesbystore")
public class SalesByStoreCtrl implements FindAllCtrl<SalesByStore> {

    private final SalesByStoreService salesByStoreService;

    @Autowired
    public SalesByStoreCtrl(SalesByStoreService salesByStoreService) {
        this.salesByStoreService = salesByStoreService;
    }


    @Override
    public BaseService<SalesByStore> getService() {
        return this.salesByStoreService;
    }

}
