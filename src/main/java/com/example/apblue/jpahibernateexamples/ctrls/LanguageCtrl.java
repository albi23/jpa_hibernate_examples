package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Language;
import com.example.apblue.jpahibernateexamples.service.LanguageService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/language")
public class LanguageCtrl implements FindAllCtrl<Language> {

    private final LanguageService languageService;

    @Autowired
    public LanguageCtrl(LanguageService languageService) {
        this.languageService = languageService;
    }


    @Override
    public BaseService<Language> getService() {
        return this.languageService;
    }

}
