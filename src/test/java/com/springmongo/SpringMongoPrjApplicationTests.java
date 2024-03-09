package com.springmongo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springmongo.entity.Student;
import com.springmongo.repo.StudentRepo;
import com.springmongo.service.StudentServiceImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest
class SpringMongoPrjApplicationTests {

	/*
	 * @Autowired private MockMvc mockmvc;
	 * 
	 * /* private WebApplicationContext context;
	 * 
	 * @Before private void setup() { mockmvc =
	 * MockMvcBuilders.webAppContextSetup(context).build();
	 * 
	 * 
	 * 
	 * }
	 */

}
