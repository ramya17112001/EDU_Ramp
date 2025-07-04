package com.day15;
 
 
public class EmailService {
 
	public String validateAndFormatEmail(String mail) throws IllegalArgumentException {
		if (mail == null) {
			throw new IllegalArgumentException("Email cannot be null");
		}
 
		String email = mail.replaceAll("\\s+", "").toLowerCase();
 
		if (!email.contains("@") || !email.endsWith(".com")) {
			throw new IllegalArgumentException("Email must contain '@' and end with '.com'");
		}
 
		return email;
	}
}
 
 