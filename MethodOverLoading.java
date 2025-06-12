package com.day3;

class Student{

	void displayInfo(String name) {
		System.out.println("Student Name:"+name);
	}
	void displayInfo(String name, int age) {
		System.out.println("Student Name:" + name+ ", Age:" + age);
	}
	
	void displayInfo(String name,int age, char grade) {
			System.out.println("Student Name:" + name + ",Age:" + age+", Grade:" + grade);
	} 
}
	
public class MethodOverLoading {
	public static void main(String[]args) { 
		Student s=new Student(); 
		s.displayInfo("ram");
        s.displayInfo("raj", 2);
        s.displayInfo("ravi",12, 'h');
	}
} 



