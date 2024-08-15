package com.springmongo;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springmongo.controller.StudentController;

@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc
public class StudentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldGetAllStudent() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/student/get"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		//.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
		
	}
	
}
