package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.StaffList;
import com.example.apblue.jpahibernateexamples.service.StaffListService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stafflist")
public class StaffListCtrl implements FindAllCtrl<StaffList> {

    private final StaffListService staffListService;

    @Autowired
    public StaffListCtrl(StaffListService staffListService) {
        this.staffListService = staffListService;
    }


    @Override
    public BaseService<StaffList> getService() {
        return this.staffListService;
    }

}
