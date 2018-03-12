package com.example.multipledatasource.event;

import com.example.multipledatasource.master.MasterBean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToMany;

//@Component
public class AnnotationRegisterListener {


   // @EventListener
    public void r(UserRegisterEvent event){
        MasterBean bean=event.getBean();
        System.out.println("我监听到了事件，我要注册"+bean.getUri());
    }
   // @EventListener
    public void email(EmailEvent event){
        MasterBean bean=event.getBean();
        System.out.println("我监听到了事件，我要email"+bean.getUri());
    }

}
