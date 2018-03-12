package com.example.multipledatasource.service;

import com.example.multipledatasource.event.EmailEvent;
import com.example.multipledatasource.event.UserRegisterEvent;
import com.example.multipledatasource.master.MasterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ApplicationContext applicationContext;

    public void register(MasterBean bean){
        bean.setUri("0000000000000");
        bean.setClientIp("10.10.10.10");
        System.out.println("注册进来了...");
        applicationContext.publishEvent(new UserRegisterEvent(this,bean));
        applicationContext.publishEvent(new EmailEvent(this,bean));
    }
}
