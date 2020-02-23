package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.NicerButSlowerFilmList;
import com.example.apblue.jpahibernateexamples.service.NicerButSlowerFilmListService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/nicerbutslowerfilmlist")
public class NicerButSlowerFilmListCtrl implements FindAllCtrl<NicerButSlowerFilmList> {

    private final NicerButSlowerFilmListService nicerButSlowerFilmListService;

    @Autowired
    public NicerButSlowerFilmListCtrl(NicerButSlowerFilmListService nicerButSlowerFilmListService) {
        this.nicerButSlowerFilmListService = nicerButSlowerFilmListService;
    }


    @Override
    public BaseService<NicerButSlowerFilmList> getService() {
        return this.nicerButSlowerFilmListService;
    }

}
