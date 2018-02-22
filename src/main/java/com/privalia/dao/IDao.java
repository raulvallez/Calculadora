package com.privalia.dao;

import java.io.IOException;
//import java.util.List;

//import com.privalia.model.Student; esto era antes con "public interface Student "


//Hay que implementar los throws implementados en la clase
public interface IDao<T> { //defino la clase en la interfaz (la T, la V...). Defino la T pq considero que sólo tengo que pasarle un modelo
	
	//mirar https://picodotdev.github.io/blog-bitix/2016/04/tutorial-sobre-los-tipos-genericos-de-java/
	int add(T model) throws IOException;
}
