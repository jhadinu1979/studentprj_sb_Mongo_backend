package com.springmongo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
 

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringMongoPrjApplicationTests {

@Autowired
private MockMvc mockmvc;

private WebApplicationContext context;

@Before
private void setup() {
	mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
	
	
	
}


}