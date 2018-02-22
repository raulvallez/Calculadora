package com.privalia.reflection;

import java.util.ArrayList;

public class EjemploReflection {
	
	public static void main(String[] args) {
		
		//Cuando crear un objeto en tiempo de ejecución, tenemos que importar el paquete de este objeto y escribirlo correctamente (en este caso el del ArrayList)
		ArrayList r = (ArrayList) createObject("java.util.ArrayList"); //Tengo que hacer un cast pq CreateObject devuelve un objeto de tipo Object
		r.add("ejemplo");
		System.out.println(r.toString());
	}
	
	//A partir de un paquete y el nombre de la clase
	static Object createObject(String className) {
		Object object = null;
		try {
			//cogemos la información de la clase (cogemos los metadatos)
			Class classDefinition = Class.forName(className);
			
			//Una vez tenemos los metadatos, podemos crear una nueva instancia
			object = classDefinition.newInstance();		
				
		} catch (InstantiationException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		return object;
				
	}

}
