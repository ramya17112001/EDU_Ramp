package com.day4;
class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
	
}
public class CustomException {
	public static void ValidateAge(int age) throws InvalidAgeException {
		if(age<36) {
		    throw new InvalidAgeException("Age " + age + " is not valid");
        } else {
            System.out.println("Age " + age + " is valid.");
        }
    }
	   public static void main(String[] args) {
	         int[] testAges = {40, 30, 60};

	        for (int age : testAges) {
	            try {
	                ValidateAge(age);
	            } catch (InvalidAgeException e) {
	                System.out.println("Caught Exception: " + e.getMessage());
	            }
	        }
	    } 
}    
 
