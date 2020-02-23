package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Inventory;
import com.example.apblue.jpahibernateexamples.service.InventoryService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryCtrl implements FindAllCtrl<Inventory> {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryCtrl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @Override
    public BaseService<Inventory> getService() {
        return this.inventoryService;
    }

}
