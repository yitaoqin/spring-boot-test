package com.example.multipledatasource;

import com.alibaba.fastjson.JSON;
import com.example.multipledatasource.annotation.ContentSecurityConstants;
import com.example.multipledatasource.util.DES3Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DESTest {

    @Autowired
    private WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testSubmit()throws Exception{
        HashMap params = new HashMap();
        params.put("name","hengyu");
        params.put("age",20);
//json转换字符串后进行加密
        String des = DES3Util.encrypt(JSON.toJSONString(params), DES3Util.DESKEY,"UTF-8");

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/submit")
                        .param(ContentSecurityConstants.DES_PARAMETER_NAME,des)
        )
                .andDo(MockMvcResultHandlers.print())
//              .andDo(MockMvcResultHandlers.log())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");

        System.out.println(result.getResponse().getContentAsString());

        Assert.assertEquals("请求失败",result.getResponse().getStatus(),200);

        Assert.assertEquals("提交失败",result.getResponse().getContentAsString(),"SUCCESS");


    }

}
