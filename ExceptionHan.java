package com.day4;

public class ExceptionHan
{
	public static void main(String[] args) {
		int arr[]= {2,4,6,8,10};
		for(int i=0; i<=5;i++) {
			System.out.println(arr[i]);
			
		}
	try {
		arr[5]=10;
	} 
	catch(ArrayIndexOutOfBoundsException ex){
		System.out.println(ex);
	}
		
	}
	}
		

		
	
	

