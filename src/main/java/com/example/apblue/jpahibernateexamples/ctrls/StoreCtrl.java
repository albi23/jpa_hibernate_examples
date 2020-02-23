package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Store;
import com.example.apblue.jpahibernateexamples.service.StoreService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")
public class StoreCtrl implements FindAllCtrl<Store> {

    private final StoreService storeService;

    @Autowired
    public StoreCtrl(StoreService storeService) {
        this.storeService = storeService;
    }


    @Override
    public BaseService<Store> getService() {
        return this.storeService;
    }

}
