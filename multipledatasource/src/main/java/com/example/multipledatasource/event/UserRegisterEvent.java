package com.example.multipledatasource.event;

import com.example.multipledatasource.master.MasterBean;
import org.springframework.context.ApplicationEvent;


public class UserRegisterEvent extends ApplicationEvent {

    private MasterBean bean;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserRegisterEvent(Object source,MasterBean bean) {
        super(source);
        this.bean=bean;
    }

    public MasterBean getBean() {
        return bean;
    }
}
