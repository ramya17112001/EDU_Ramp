package com.day11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
 
class Contact1{
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	public Contact1(String name, String phoneNumber, String email,String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address=address;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getaddress() {
		return address;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
       if (!(o instanceof Contact1)) return false;
        Contact1 contact = (Contact1) o;
        return name.equalsIgnoreCase(contact.name) &&
               phoneNumber.equals(contact.phoneNumber)&&
               address.equals(address);
    }
	 @Override  
	    public int hashCode() { 
	        return Objects.hash(name.toLowerCase(), phoneNumber);
	    }

	@Override
	public String toString() {
		return "Contact1 [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ "]";
	}
	 
 
	 
}
public class AlphabeticSortByName {
	public static void main(String[] args) { 
		Contact1[] simContacts = {
	            new Contact1("Jeevan", "9876543210", "jeevan@sim.com","hyd"),
	            new Contact1("Nisha", "9123456789", "nisha@sim.com","hyd"),
	            new Contact1("Chitti", "9988776655", "chitti@sim.com","chennai")
	        };
		 // Contacts from Google
        Contact1[] googleContacts = {
        		new Contact1("Jaya", "9876543210", "jaya@sim.com","hyd"),
                new Contact1("Nivetha", "9123456789", "nivi@sim.com","chennai"),
                new Contact1("Chitti", "9988776655", "chitti@sim.com","hyd")     // Duplicate
        };
 
        // Contacts from Outlook
        Contact1[] phoneContacts = {
        		new Contact1("Srinivas", "9876543210", "srinivas@sim.com","hyd"),
                new Contact1("Chityala", "9123456789", "chityala@sim.com","chennai"),
                new Contact1("Nivetha", "9123456789", "nivi@sim.com","hyd")
        };
 
		
		 Set<Contact1> uniqueContacts = new HashSet<>();
		 Collections.addAll(uniqueContacts, simContacts);
		 Collections.addAll(uniqueContacts, googleContacts);
		 Collections.addAll(uniqueContacts, phoneContacts);
		 // Convert to List and sort alphabetically by name
		 List<Contact1> sortedContact = new ArrayList<>(uniqueContacts);
		 sortedContact.sort(Comparator.comparing(Contact1::getName, String.CASE_INSENSITIVE_ORDER));
		 Map<String, List<Contact1>> groupedByAddress = new HashMap<>();
	        for (Contact1 contact : sortedContact) {
	            groupedByAddress
	                .computeIfAbsent(contact.getaddress().toLowerCase(), k -> new ArrayList<>())
	                .add(contact);
	        }
	        System.out.println("Contacts Grouped by Address:");
	        for (Map.Entry<String, List<Contact1>> entry : groupedByAddress.entrySet()) {
	            System.out.println("Address: " + entry.getKey());
	            for (Contact1 contact : entry.getValue()) {
	                System.out.println(" - " + contact);
	            }
	            System.out.println(); 
	        }  
		 //Display contacts
//		 System.out.println(" alphabecatilly sorted contacts : ");
//		 for(Contact1 c : sortedContact ) {
//			 System.out.println(" - " +c);
//		 }    

	}     
 
}