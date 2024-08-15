package com.springmongo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmongo.entity.Student;
import com.springmongo.repo.StudentRepo;
import com.springmongo.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMokitoApplicationTest {

	//private static final String End_Point_Url = "http://localhost:8081/api/v1/student";
	private static final String End_Point_Url = "/api/v1/student";

	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean	
	private StudentRepo repository;

	@Test
	public void listAllStudentsTest() throws Exception {
		when(repository.findAll()).thenReturn(Stream
				.of(new Student("65c2423681d40d4641092324", "Andrew", "USA", "888888888"),
						new Student("65c2423681d40d4641092325", "Alixy", "UK", "666666666"))
				.collect(Collectors.toList()));
		//ResultActions  action =mockMvc.perform(get(End_Point_Url)).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(""));
		
		Assert.assertEquals(2, studentService.listAllStudents().size());
	}

	@Test
	public void searchStudentByIdTest() {
		String id = "65c2423681d40d4641092324";
		when(repository.findStudentById(id))
				.thenReturn(Stream.of(new Student("65c2423681d40d4641092324", "Andrew", "USA", "888888888"))
						.collect(Collectors.toList()));
		Assert.assertEquals("65c2423681d40d4641092324", studentService.searchStudentById(id).getId());
	}

	@Test
	public void saveorUpdateTest() {
		Student student = new Student("65c2423681d40d4641092329", "Andrew1", "USA", "888888888");
		when(repository.save(student)).thenReturn(student);
		Assert.assertEquals(student, studentService.saveorUpdate(student));

	}

	@Test
	public void deleteStudentTest() {
		Student student = new Student("65c2423681d40d4641092329", "Andrew1", "USA", "888888888");
		String studentid = "65c2423681d40d4641092329";
		studentService.deleteStudent(studentid);

		verify(repository, times(1)).deleteById(studentid);
	}

	@Test
	public void testAddShouldReturn400BadRequest() throws Exception {
		Student newStudent = new Student("", "", "", "");
		//Student newStudent = new Student().getStudentAddress().getStudentName().getMobile();

		String requestBody = objectMapper.writeValueAsString(newStudent);

		mockMvc.perform(post(End_Point_Url).contentType("application/json").content(requestBody))
				.andExpect(status().isBadRequest());

	}
	@Test
	public void testAddShouldReturn201Created() throws Exception {
		Student newStudent = new Student("65c2423681d40d4641092321", "John", "Russia", "88899999");

		String requestBody = objectMapper.writeValueAsString(newStudent);

		mockMvc.perform(post(End_Point_Url).contentType("application/json").content(requestBody))
				.andExpect(status().isCreated())
				.andDo(print());

	}
	
	@Test
	public void testgetStudentShouldReturn201Created() throws Exception {
		Student newStudent = new Student("65c2423681d40d4641092321", "John", "Russia", "88899999");
		//Student student = Student.builder()
		String requestBody = objectMapper.writeValueAsString(newStudent);

		mockMvc.perform(post(End_Point_Url).contentType("application/json").content(requestBody))
				.andExpect(status().isCreated())
				.andDo(print());

	}
	
	@Test
	public void testgetStudentShouldReturn404NOTFound() throws Exception{
		
		String studentId = "65c2423681d40d4641092323";
		String requestURI = End_Point_Url + "/" +studentId;
		mockMvc.perform(get(End_Point_Url).contentType("application/json"))
		.andExpect(status().isNotFound())
		.andDo(print());
		
	}

}
