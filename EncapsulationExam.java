package com.day3;
class Student1 {
	private String name;
	private int age;
	private String course;
	public Student1(String name, int age, String course) {
	
		this.name = name;
		this.age = age;
		this.course = course;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void displayDetails() {
		System.out.println("name:"+name);
		System.out.println("age:"+age);
        System.out.println("course:"+course);
 }  
	
} 
public class EncapsulationExam {
	public static void main(String[]args) {
		Student1 student=new Student1("ramya",20,"ece");
		Student1 student3=new Student1("vinnu",24,"computer science");
		student.displayDetails(); 
		student3.displayDetails();  
//		student.setAge(24); 
//		student.setCourse("eee");
//		System.out.println("\nafter update:");
//		student.displayDetails();
	}
   
}
