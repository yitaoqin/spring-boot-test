package com.example.multipledatasource.job;

import com.example.multipledatasource.master.MasterJPA;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobTest {

    @Autowired
    private MasterJPA jpa;

    @Scheduled(cron="* 0/30 * * * ?")
    public void print(){
        System.out.println(StringUtils.compare("30","20"));
    }

    public static void main(String[] args) {
        System.out.println("30".compareTo("40"));
    }
}
