package com.day3;

class Book1 {
	String title;
	Author author;
	Book1(String title, Author author){
		this.title=title;
		this.author=author;
		
	}    
	Book1(Book1 b){
		this.title=b.title;
		this.author=b.author;
	}
	void display() {
		System.out.println("Book:"+title+",Author:"+author.name);
		 
	} 

	}
class Author{
	String name;
	Author(String name){
		this.name=name;
	}
}

  public class Book{
	public static void main(String[]args) {
		Author a1=new Author("j.k rowlig");
		Book1 b1 = new Book1("harry potter",a1);
		Book1 b2=new Book1(b1);
		System.out.println("changing author");
		b1.display();
		b2.display();
		b2.author.name="New Author";
		System.out.println("\n change author name");
		b1.display();
		b2.display();
	}
    }

