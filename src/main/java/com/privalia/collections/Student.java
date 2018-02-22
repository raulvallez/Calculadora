package com.privalia.collections;

public class Student {
	private int idStudent;
	private String name;
	private String surname;
	private int age;
	
	//relación 1 a 1
	private Address address;
	
	public Student(){
		
	}
	
	public Student(Address addres){
		
	}
	
	public Student(Student student, Address addres){
		
	}
	
	public Student(int idStudent, String name, String surname, int age){
		
	}
	
	public Student(int idStudent, String name, String surname, int age, Address address){
		
	}
	

	
	private static Student getStudent(){
		return new Student();
	}

	/**
	 * @return the idStudent
	 */
	public int getIdStudent() {
		return idStudent;
	}
	/**
	 * @param idStudent the idStudent to set
	 */
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
