package com.privalia.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger; //Es la que usamos para nuestro logger. Ojo! que hay más de uno y nosotros usamos este. (Tb pq tenemos la dependencia de Maven)

import lombok.extern.log4j.Log4j;
//Ninguna observación de sonarlint, si no cuando lo suba, petará
//Cuando creo una FileUtil con métodos estáticos petará pidiendo un constructor privado .
//Un factory method, sería un metodo estático para crear objetos

//Si quiero instanciar una fileutil sería usando un constr.estático

//La anotación te crea una variable log
@Log4j
 public class FileUtil {
	
	//Si ponemos la anotación @Log4j, podemos eliminar la siguiente línea
	// static final Logger logger = Logger.getLogger(FileUtil.class);
	private static File file = null; //Si quiesiera más de un file, lo haría con array usando clave-valor
	
	private FileUtil() {
		//Lo pongo vacío y privado para que no instancies esta clase, dado que es de métodos estáticos
		//Conceptualmente no puedes instalciar una Util
		//El static ... es método o atributo
		//De esta manera no puedes crear objetos de FileUtil
		
		//Al ponerlo privado, fuerzo a que la única manera de crear el fichero sea con el método estático "createFile" y evito usar el constructor
	}
	
	//synchronized para que sólo use un thread en el exception
	public static synchronized boolean createFile(String fileName) throws IOException{
		boolean isFileCreated = false;
		file =new File(fileName);
		
		if(file.exists()){
			//envío un warning
			//Si no usamos anotación @log4j usamos la siguiente línea
			//logger.warn("fichero existe");
			log.warn("fichero existe");
			
		}
		else
		{
			try{
				isFileCreated = file.createNewFile();
			} 
			catch(Exception e)
			{
				//synchronized para que sólo use un thread en el exception
//				logger.error(e.getMessage());
//				logger.error(e.getStackTrace());	
				
				//Usando el @log4j de lombok 
				log.error(e.getMessage());
				log.error(e.getStackTrace());
				//hacemos el throw para que el de arriba se entere.
				throw e;
			}
		}
		
		return isFileCreated;
	}
	
	//Aquí no se pone el synchronized pq no hay ifs ni condiciones. Si entra dos trheads, da igual
	public static File getFile() {
		return file;
	}
	
}