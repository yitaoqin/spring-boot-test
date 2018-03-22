package com.example.multipledatasource.slave;

import com.example.multipledatasource.dto.*;
import com.example.multipledatasource.master.MasterBean;
import com.example.multipledatasource.master.MasterJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("slave")
public class SlaveController {

    @Autowired
    private SlaveJPA slaveJPA;
    @Autowired
    private MasterJPA masterJPA;
    @Autowired
    private MapperDTO mapperDTO;


    @RequestMapping("list")
    public List<GoodInfoDTO> list(){
        List<SlaveBean> slaveList=slaveJPA.findAll();
        List<MasterBean> masterList=masterJPA.findAll();

        return mapperDTO.fromGoodInfoDTO(masterList.subList(0,10),slaveList.subList(0,10));
    }


    @RequestMapping("one")
    public GoodInfoDTO one(){
        SlaveBean bean=slaveJPA.findOne("13");
        MasterBean masterBean=masterJPA.findOne("123");
        return mapperDTO.from(masterBean,bean);
    }
}
