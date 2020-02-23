package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Country;
import com.example.apblue.jpahibernateexamples.service.CountryService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/country")
public class CountryCtrl implements FindAllCtrl<Country> {

    private final CountryService countryService;

    @Autowired
    public CountryCtrl(CountryService countryService) {
        this.countryService = countryService;
    }


    @Override
    public BaseService<Country> getService() {
        return this.countryService;
    }

}
