package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Staff;
import com.example.apblue.jpahibernateexamples.service.StaffService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/staff")
public class StaffCtrl implements FindAllCtrl<Staff> {

    private final StaffService staffService;

    @Autowired
    public StaffCtrl(StaffService staffService) {
        this.staffService = staffService;
    }


    @Override
    public BaseService<Staff> getService() {
        return this.staffService;
    }

}
