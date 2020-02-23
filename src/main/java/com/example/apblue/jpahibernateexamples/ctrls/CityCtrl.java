package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.City;
import com.example.apblue.jpahibernateexamples.service.CityService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/city")
public class CityCtrl implements FindAllCtrl<City> {

    private final CityService cityService;

    @Autowired
    public CityCtrl(CityService cityService) {
        this.cityService = cityService;
    }


    @Override
    public BaseService<City> getService() {
        return this.cityService;
    }

}
