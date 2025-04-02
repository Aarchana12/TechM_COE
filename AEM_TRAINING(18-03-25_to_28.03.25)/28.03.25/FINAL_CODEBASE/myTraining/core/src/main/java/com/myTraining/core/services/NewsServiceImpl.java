package com.myTraining.core.services;

import org.osgi.service.component.annotations.Component;

@Component(service = NewsService.class)
public class NewsServiceImpl implements NewsService {

    @Override
    public String sayHello() {
        return "Hello World";
    }
}
