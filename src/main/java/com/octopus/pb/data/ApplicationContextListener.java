package com.octopus.pb.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    InitDataBuilder initDataBuilder;

    private volatile boolean isRefreshed = false;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        if (isRefreshed == false) {
//            initDataBuilder.buildData();
//            isRefreshed = true;
//        }
    }

}
