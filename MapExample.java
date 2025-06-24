package com.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
//		
		Map<String,List<String>> customer = new HashMap<>();
		// Add customer name
				customer.put("Fashion",Arrays.asList( "Preetti","Kavya","Nisha"));
			 	customer.put("Laptops",Arrays.asList( "Chityala","Nivetha","ChittiRaja"));
				//System.out.println(customer);
				 customer.putIfAbsent("Electronics", new ArrayList<>());
				 customer.get("Electronics").add("Jaya");
				 System.out.println(customer.size());
			 	 System.out.println(customer.containsKey("Fashion"));
				 System.out.println(customer.containsValue(Arrays.asList("Preetti","Kavya","Nisha")));
				 
				// Printing the map
				for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
					System.out.println("Category: " +entry);
				}

				for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
					System.out.println("Category: " +entry.getKey());
				}
				for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
					System.out.println("Category: " +entry.getValue());
				}
				for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
					System.out.println("Category: " +entry.getKey() + "Customer" + entry.getValue());
				}
			
	}
} 
