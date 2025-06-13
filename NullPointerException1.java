package com.day4;
class Employee{
	String ename;
	int eid;
	
	public Employee(int eid) {
		this.eid=eid;
	} 
}

public class NullPointerException1 {
	public static void main(String[]args) {
		Employee e=new Employee(10);
		System.out.println("eid:"+e.eid);
		try {
			System.out.println("name:"+e.ename.length());
		}
		catch(NullPointerException ex) { 
			System.out.println("name");
		}
	}
	  

}
