package com.example.multipledatasource.slave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("slave")
public class SlaveController {

    @Autowired
    private SlaveJPA masterJPA;

    @RequestMapping("list")
    public List<SlaveBean> list(){
        return masterJPA.findAll();
    }
}
