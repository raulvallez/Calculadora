package com.privalia.model;

import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.Gson.*;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@EqualsAndHashCode
//@NoArgsConstructor
@RequiredArgsConstructor
public class Student extends PrivaliaObject{
	
//	@NonNull
	private int idStudent;
	private String name;
	private String surname;
	private int age;
	
	static int numero;
	
	//Inicializador estático que inicializa los atributos estáticos de la clase
	static {
		numero = 10;
	}
	
	public static Student getStudent(){
		return new Student();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + idStudent;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (idStudent != other.idStudent)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if(!super.equals(other.getUUID()))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(idStudent);
		builder.append(",");
		builder.append(name);
		builder.append(",");
		builder.append(surname);
		builder.append(",");
		builder.append(age);
		builder.append(",");
		builder.append(getUUID().toString());
		builder.append("");
		return builder.toString();
	}
	
	public String toJson() {		
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this);
		
		return jsonInString;
	}

	
//AMB LOMBOK getters and setters van fora.	
//	/**
//	 * @return the idStudent
//	 */
//	public int getIdStudent() {
//		return idStudent;
//	}
//	/**
//	 * @param idStudent the idStudent to set
//	 */
//	public void setIdStudent(int idStudent) {
//		this.idStudent = idStudent;
//	}
//	/**
//	 * @return the name
//	 */
//	public String getName() {
//		return name;
//	}
//	/**
//	 * @param name the name to set
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//	/**
//	 * @return the surname
//	 */
//	public String getSurname() {
//		return surname;
//	}
//	/**
//	 * @param surname the surname to set
//	 */
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}
//	/**
//	 * @return the age
//	 */
//	public int getAge() {
//		return age;
//	}
//	/**
//	 * @param age the age to set
//	 */
//	public void setAge(int age) {
//		this.age = age;
//	}
	
//Amb lombok no fa falta, ya lo hace con la anotación @NoArgsConstructor
//	public Student()
//	{
//		super();
//	}
	
	public Student(int idStudent, String name, String surname, int age)
	{
		super();
		this.idStudent = idStudent;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public Student(int idStudent, String name, String surname, int age, UUID uuid)
	{
		super(uuid);
		this.idStudent = idStudent;
		this.name = name;
		this.surname = surname;
		this.age = age;
		
	}
	
}
