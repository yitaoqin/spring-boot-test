package com.example.multipledatasource.dto;

import com.example.multipledatasource.master.MasterBean;
import com.example.multipledatasource.slave.SlaveBean;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MapperDTO {

    @Mappings({
            @Mapping(source = "master.clientIp",target = "clientIp"),
            @Mapping(source = "master.uri",target = "uri"),
            @Mapping(source = "slave.areaName",target = "areaName"),
            @Mapping(source = "slave.areaCode",target = "areaCode")
    })
    public abstract GoodInfoDTO from(MasterBean master, SlaveBean slave);


    public List<GoodInfoDTO> fromGoodInfoDTO(List<MasterBean> masterList, List<SlaveBean> slaveList){
       List<GoodInfoDTO> dtoList=new ArrayList<>();
       int size=Math.max(masterList.size(),slaveList.size());

       MasterBean master;
       SlaveBean slave;
       for (int i = 0; i < size; i++) {
           master=masterList.get(i);
           slave=slaveList.get(i);

           dtoList.add(from(master,slave));
       }
       return dtoList;
   }
}
