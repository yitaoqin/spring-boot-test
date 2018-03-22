package com.example.multipledatasource.event;

import com.alibaba.fastjson.JSONObject;
import com.example.multipledatasource.master.MasterBean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToMany;
import java.util.*;

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

    public static void main(String[] args) {
        List<JSONObject> d=new ArrayList<>() ;
        JSONObject j=new JSONObject();
        j.put("a",12);
        JSONObject jj=new JSONObject();
        jj.put("a",15);
        JSONObject jjj=new JSONObject();
        jjj.put("a",11);
        d.add(j);
        d.add(jj);
        d.add(jjj);
        d.forEach(System.out::println);
        d.sort((o1,o2)->{
            int o1v=o1.getIntValue("a");
            int o2v=o2.getIntValue("a");
            if(o1v == o2v)return 0;
            if(o1v > o2v)return 1;
            if(o1v < o2v)return -1;
            return 0;
        });
        d.forEach(System.out::println);
    }

}
