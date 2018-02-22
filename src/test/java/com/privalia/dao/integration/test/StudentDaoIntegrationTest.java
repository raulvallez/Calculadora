package com.privalia.dao.integration.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.privalia.dao.INio;
import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.FileUtil;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.UUID;

import com.privalia.util.FileType;


public class StudentDaoIntegrationTest {
	
	//es como una constante, sólo puedo asignar la variable una vez. No puedo asignarlo en el constructor
	static final Logger logger = Logger.getLogger(StudentDaoIntegrationTest.class);
	
	static Properties prop = null;
	static FileInputStream input = null;
	
//	Junit crea una instancia de la clase cada vez que ejecuto un testeo. El inicializador estático NO se puede utilizar. Emulo el inicializador con la anotación @BeforeClass
//	Aquí leo el fichero de properties.
	@BeforeClass
	public static void setup() {
		prop = new Properties();
		{
			try {
				input = new FileInputStream("src/main/resources/config.properties");
				prop.load(input);
			} catch (IOException e) {
				logger.error(e.getMessage());
				
				//error en la inicialización.
				
				//mirar checked vs unchecked exceptions o  managed and unmanaged exception
				
				//ExceptionInInitializerError, sería un wrapping de excepciones
				throw new ExceptionInInitializerError(e);
				
				//Si quiero un mensaje probpio
				//throw new ExceptionInInitializerError(e,"My Mensaje de error propio");
				//Sería de ideal que los mensajes de error estuviera en un fichero de propiedades.
				
			}
		}
	}
	
	
	@Test
	public void testAdd() throws IOException {
		Student alumnoEnviado = 
				new Student(1, "Giuseppe", "Pesce", 43);
		StudentDao studentDao = new StudentDao();
		//int idStudent = studentDao.add(alumnoEnviado);
		
		int idStudent = studentDao.add(alumnoEnviado);
		//Student alumnoEncontrado = findAlumno(alumnoEnviado.getIdStudent()); //mejor:
		Student alumnoEncontrado = findAlumno(idStudent);
		//assertEquals(1,1);
		assertEquals(alumnoEncontrado,alumnoEnviado);
	}
	
	@Test
	public void testAddJson() throws IOException {
		Student alumnoEnviado = 
				new Student(1, "Giuseppe", "Pesce", 43);
		StudentDao studentDao = new StudentDao();
		//int idStudent = studentDao.add(alumnoEnviado);
		
		int idStudent = studentDao.add(alumnoEnviado, FileType.JsonFile);
		//Student alumnoEncontrado = findAlumno(alumnoEnviado.getIdStudent()); //mejor:
		Student alumnoEncontrado = findAlumno(idStudent);
		//assertEquals(1,1);
		assertEquals(alumnoEncontrado,alumnoEnviado);
	}
	

	
//	
//	public void AddWithNio() throws IOException {
//		Student alumnoEnviado = 
//				new Student(1, "Giuseppe", "Pesce", 43);
//		
//		//StudentDao studentDao = new StudentDao(); 
//		INio<Student> studentDaoNio = new StudentDao();
//		
//		studentDaoNio.addWithNio(alumnoEnviado);
//		
//		Student alumnoEncontrado = findAlumnoWithNio(alumnoEnviado.getIdStudent());
//		assertEquals(alumnoEncontrado,alumnoEnviado);
//	}
	
	
	
	private Student findAlumno(int idAlumno) throws IOException {
		boolean encontrado = false;
		File fichero = FileUtil.getFile();
		String[] alumnostring = null;
		
		try (Scanner s = new Scanner(fichero)) { //Scanner es closable
			while(s.hasNextLine() || encontrado == false) {
				String linea = s.nextLine();
				alumnostring = linea.split(",");
				
				if(Integer.parseInt(alumnostring[0]) == idAlumno){
					encontrado = true;
				}
			}
		}
		catch(IOException e){
			//e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		
		Student student = null;
		if(encontrado == true)
		{
			student = new Student(
					Integer.parseInt(alumnostring[0].trim()),
					alumnostring[1].trim(),
					alumnostring[2].trim(),
					Integer.parseInt(alumnostring[3].trim()),
					UUID.fromString(alumnostring[4].trim())
					);
//			student.setIdStudent(Integer.parseInt(alumnostring[0].trim()));
//			student.setName(alumnostring[1].trim());
//			student.setSurname(alumnostring[2].trim());
//			student.setAge(Integer.parseInt(alumnostring[3].trim()));
//			student.setUUID(Integer.parseInt(alumnostring[4].trim()));
		}
		
		return student;		
	}
	
	
	private Student findAlumnoWithNio(int idStudent) throws IOException
	{
		Student student = null;
		
		//RandomAccessFile como FileChannel implementan closable -> pongo los dos dentro del try para que sea luego autoclosable
		try (RandomAccessFile aFile = new RandomAccessFile("Alumno.txt", "rw");
				FileChannel fileChannel = aFile.getChannel()){ //fileChannel es el canal que uso para conectarme al fichero. Puede haber varios channels del mismo file (multithreading)
			
			//Le digo el tamaño de mi memoria en BYTES, ya que trabajaré en memoria
			ByteBuffer byteBuffer = ByteBuffer.allocate(48); //Un String ocupa 48 bytes, así que usamos 48
			StringBuffer line = new StringBuffer();
			String [] alumnoString = null;
			boolean isFinished = false;
			while(fileChannel.read(byteBuffer) > 0 && !isFinished)
			{
				//byteBuffer.rewind();
				//Sytem.out.print(charset.decode(...
				byteBuffer.flip(); //le dices "inviertete al revés" para inicializar el puntero al inicio
				for(int i = 0; i < byteBuffer.limit(); i++) 
				{
					
					char ch = ((char) byteBuffer.get());
					if(ch != '\n'){
						String stringLine = line.toString(); //la line es un streamBuffer
						alumnoString = stringLine.split(",");
						if(Integer.parseInt(alumnoString[0]) == idStudent) {
							//Usamos el factory method
							student = Student.getStudent();
							student.setIdStudent(
									Integer.parseInt(alumnoString[0].trim())
									);
							student.setName(
									alumnoString[1]
									);
							student.setSurname(
									alumnoString[2]
									);
							student.setIdStudent(
									Integer.parseInt(alumnoString[3].trim())
									);
							
							//salir del while
							isFinished = true;
							//salimos del for
							break;	
						}
						line = new StringBuffer();
					}
					else {
						line.append(ch);
					}

				}
				byteBuffer.clear();
				
			}
		} catch(IOException e) {
			logger.error(e.getMessage());
			throw e;
		}

		return student;
	}
	
	
	@AfterClass
	public void tearDown() throws IOException
	{
		File f = FileUtil.getFile();
		if(f.exists()) {
			f.delete();
		}
	}
	
	
	
}

