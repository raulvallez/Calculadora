package com.privalia.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student(1,"Pepe","Soto", 24);
		
	
		//Arraylist no generico con la interfaz List
		List studentList = new ArrayList();
		int counter = 4;
		
		//Ejemplo de Boxing
		studentList.add(student);
		//Ejemplo de Autoboxing (el int a partir de java 5 lo traspasa a objeto Integer)
		studentList.add(counter);
		
		//Ejemplo de unboxing
		Student newStudent = (Student) studentList.get(0); //Obtengo el primer elemento; 
		
		//studentList.get(0); //sólo vería los atributos de object
		//((Student) studentList.get(0)); //vería los atribugos de Student;
		
		String name=((Student)studentList.get(0)).getName();
		
		//Lista Genérica - es fuertemente tipado. Si paso un Object me va a petar Recomendación: Las colecciones tienen que ser strong typed
		List<Student> genericStudentList = new ArrayList<Student>(); //podemos añadir Student o clases que hereden de Student
		genericStudentList.add(student); 
		
		Student newStudent2 = genericStudentList.get(0);
		
		//Optional pq quizás no haya un elemento
		Optional<Student> optionalStudent = genericStudentList.stream()  //stream es nuevo de java8
				.filter(p -> p.getName().equals("Pepe")) 
				.findFirst();
		
		Student searchedStudend = optionalStudent.get();
		
	}

}
