package com.springmongo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.springmongo.entity.Student;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // while bootstraping the spring context Run
@RunWith(SpringRunner.class)
@SpringBootTest // with random port

@WebMvcTest
class SpringMongoPrjApplicationTests {

	@LocalServerPort
	private int port;

	/// private String baseUrl = "http://localhost:8081/api/v1/student";
	String baseUrl = "http://localhost:8081/api/v1/student/get";
	private static RestTemplate restTemplate;
	// @Autowired
	// private static StudentRepoTest studentRepoTest;

	// It will run before running all test case
	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	// Before running each test case it will run

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "/").concat("api/v1/student");
	}

	// String baseUrl = "http://localhost:" + port + "/";

	@Test 
	  public void testSaveStudent() { 
		Student student = new Student("65c2423681d40d4641092323", "Dinesh", "Bangalore", "9916462775");
	  Student response = restTemplate.postForObject(baseUrl, student, Student.class); 
	  assertEquals("65c2423681d40d4641092323", response.getId());
	  // verify id present in DB or not // assertEquals(1,
	  //studentRepoTest.findAll().size()); // verify 1 record added }
	 
	}
}