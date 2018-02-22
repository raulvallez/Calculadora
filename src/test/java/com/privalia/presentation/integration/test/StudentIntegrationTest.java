package com.privalia.presentation.integration.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.privalia.model.Student;
import com.privalia.presentation.Main;
import com.privalia.util.FileManager;
import org.apache.log4j.Logger;

public class StudentIntegrationTest {
	
	static final Logger logger = Logger.getLogger(Student.class);
	
	@Test
	public void testAdd() {
		Student student = new Student(1,"Lola", "Flores",65);
				
		assertTrue(student.equals(student));

		String result = FileManager.read();
		
		result = result.replaceFirst("Studen [", "");
		result = result.replaceFirst("]", "");
		String[] parts = result.split(", ");
		
		logger.info("Student --- " + result);
		
//		for(int i=0, i<result.length i++){
//			
//		}

	}
	
}
