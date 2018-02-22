package com.privalia.dao;

import static com.privalia.util.FileUtil.createFile;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.privalia.model.Student;
import com.privalia.presentation.Main;
import com.privalia.util.FileManager;
import com.privalia.util.FileType;

import org.apache.log4j.Logger;
import com.privalia.util.FileType;

public class StudentDao implements IDao<Student>, INio<Student> {

	static final Logger logger = Logger.getLogger(StudentDao.class);
	static Properties prop = null;
	static FileInputStream input = null;
	
	static {
		prop =new Properties(); //leer fichero de propiedades
		try {
			input = new FileInputStream("src/main/resources/config.properties");
			prop.load(input);
		}
		catch (IOException e) {  //Para cracks usar NIO (relacionado con big data)
			logger.error(e.getMessage());
			throw new ExceptionInInitializerError(e); //Wrapping de exception lanzando una runtime exception, dado que el inicializador estatico no deja lanzar checked exceptions
													 //No la importo pq ya está en java.lang. La mayoría de runtime exceptions están en java land
		}
	}
	
	
	@Override
	public int addWithNio(Student student) throws IOException {
		
		String fileName = prop.getProperty("filename");
		
		Path path = Paths.get(fileName);
		
		try(BufferedWriter writer = Files.newBufferedWriter(path, 
				Charset.forName("UTF-8"), 
				StandardOpenOption.APPEND))
		{ 
			writer.write(student.toString());
			writer.write(System.lineSeparator());
		} catch (IOException e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
			throw e;
		}
				
		return student.getIdStudent(); //Es el que compararé en el unit test
	}
	
	@Override
	public int add(Student student) throws IOException {
		String fileName =  prop.getProperty("filename");
		
		//nuevo?!?!
		createFile(fileName);
		
		try (FileWriter fileWriter = new FileWriter(fileName,true);
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter))
		{ //el true hace un append, si no, no va a funcionar
			
			//bufferWriter.write(student.toString()); //encapsula la concatenación del string
			bufferWriter.write(student.toJson());
			bufferWriter.write(System.lineSeparator());
		} catch(IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return student.getIdStudent(); //Es el que compararé en el unit test
	}	
	
	
	
//	public int add(Student student, FileType fileType) throws IOException {
//		int idStudent = 0;
//		
//		switch(fileType) {
//			case JsonFile:
//				idStudent = this.add(student);
//				break;
//			default:
//				idStudent = this.addJson(student);
//				break;
//		}
//		
//		return idStudent;
//	}

}
