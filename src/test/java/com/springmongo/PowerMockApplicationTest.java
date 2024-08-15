package com.springmongo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import com.springmongo.service.StudentServiceImpl;
import com.springmongo.util.NotificationUtil;

@RunWith(PowerMockRunner.class) 
@PrepareForTest(fullyQualifiedNames = "com.springmongo.test.*")
public class PowerMockApplicationTest {
	
	/*@InjectMocks*/
	//private StudentServiceImpl studentService;
	
	@Before
	/*
	 * public void init() { MockitoAnnotations.initMocks(NotificationUtil.class); }
	 */
	public void testStaticMethod() {
		//BDD - Behavioural Driven Development
		
		//Given
		//String emailId="test@gmail.com";
		//PowerMockito.mockStatic(NotificationUtil.class);
		//When
		
		//Then
		
	}

}
