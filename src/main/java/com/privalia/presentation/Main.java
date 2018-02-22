package com.privalia.presentation;

import org.apache.log4j.Logger;
import java.util.Scanner;

import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.MethodInfo;


public class Main {

	//Usa reflection (instropección) -> instancia los datos de la clase en tiempo de ejecución
	static final Logger logger = Logger.getLogger(Main.class);
	
	@MethodInfo(author="Francisco",
			revision = 4,
			comments = "My first comment",
			date = "22/092017"
			)
	public static void main(String[] args) {
		//with setters
		Student student1 = new Student();
		student1.setIdStudent(1);
		student1.setName("pepe");
		student1.setSurname("Soto");
		student1.setAge(40);
	
		//with constructor
		Student student2 = new Student(1,"Albert","Sierra",44);
		
//		Scanner scanner = new Scanner(System.in);
		
		
//		boolean exit = false;
//		Scanner scanner = new Scanner(System.in);
//		
//		while(!exit)
//		{
//			
//			logger.info("1. Agregar alumno");
//			logger.info("2. Salir");
//			
//			
//			switch(scanner.nextInt()) {
//				case 1:
//					logger.info("Has picado 1");
//					break;
//				case 2:
//					exit = true;
//					break;
//				default:
//					logger.info("wront value");
//					break;				
//			}
//		}
		
		
//		String input = "1 fish 2 fish red fish blue fish";
//	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
//	     System.out.println(s.nextInt());
//	     System.out.println(s.nextInt());
//	     System.out.println(s.next());
//	     System.out.println(s.next());
//	     s.close(); 
		
		
//		System.out.println("Student1 Name: " + student1.getName());
//		System.out.println("Student2 Name: " + student2.getName());
		
		//http://programacion.jias.es/2013/03/log4j-tutorial-configuracion-rapida/
		logger.info("Student1 Name: " + student1.getName());
		logger.info("Student1 id: " + student1.getIdStudent());
		logger.info("Student1 Surname: " + student1.getSurname());
		logger.info("Student1 Age: " + student1.getAge());
		
		logger.info("Student2 Name: " + student2.getName());
		logger.info("Student2 id: " + student2.getIdStudent());
		logger.info("Student2 Surname: " + student2.getSurname());
		logger.info("Student2 Age: " + student2.getAge());
		
		StudentDao studentDao = new StudentDao();
		//studentDao.add(student1);
	}
}
