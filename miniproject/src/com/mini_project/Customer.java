package com.mini_project;
 
public class Customer {
	private final String id;
    private String name;
    private Plan plan;
 
    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public String getId() { return id; }
    public String getName() { return name; }
    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }

}
