package com.example.multipledatasource.master;

import com.example.multipledatasource.HelloService;
import com.example.multipledatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("master")
public class MasterController {

    @Autowired
    private UserService service;

    @Autowired
    private HelloService helloService;

    @RequestMapping("list")
    public String list(){
        service.register(new MasterBean());
        return "事件调用成功";
    }

    @RequestMapping("say")
    public String sayHello(){
        return helloService.sayHello();
    }
}
