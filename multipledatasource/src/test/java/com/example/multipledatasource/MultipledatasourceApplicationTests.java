package com.example.multipledatasource;

import com.example.multipledatasource.master.MasterJPA;
import com.example.multipledatasource.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipledatasourceApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MasterJPA jpa;

    @Autowired
	private UserService userService;

    @Before
	public void before(){
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}


	@Test
	public void contextLoads() {
        userService.register(null);
        System.out.println(jpa.count());
    }

    @Test
    public void testList() throws Exception {
	    MvcResult mvcResult=mockMvc.perform(
	            MockMvcRequestBuilders
                        .post("/master/say")

        ).andReturn();
	    int status=mvcResult.getResponse().getStatus();
	    String responseString=mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("返回状态码",200,status);
        System.out.println(responseString);

    }

}
