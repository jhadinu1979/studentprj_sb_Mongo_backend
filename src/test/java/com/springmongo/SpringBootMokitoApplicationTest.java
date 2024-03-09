package com.springmongo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springmongo.entity.Student;
import com.springmongo.repo.StudentRepo;
import com.springmongo.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMokitoApplicationTest {


	@Autowired
	private StudentServiceImpl studentService;

	@MockBean
	private StudentRepo repository;

	@Test
	public void listAllStudentsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Student("65c2423681d40d4641092324", "Andrew", "USA", "888888888"),
						new Student("65c2423681d40d4641092325", "Alixy", "UK", "666666666"))
				.collect(Collectors.toList()));
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


}
