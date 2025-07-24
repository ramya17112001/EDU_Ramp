package com.billing_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;


public class Plan {
	
	
	private Long id;
    private String name;
    private String type;
    private double price;
    private int validity;
    private double includedData; 
    private double extraDataRate; 

    public Plan() {}
    public Plan(Long id, String name, String type, double price, int validity, double includedData, double extraDataRate) {
        this.id = id; this.name = name; this.type = type; this.price = price; this.validity = validity;
        this.includedData = includedData; this.extraDataRate = extraDataRate;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public double getIncludedData() {
		return includedData;
	}
	public void setIncludedData(double includedData) {
		this.includedData = includedData;
	}
	public double getExtraDataRate() {
		return extraDataRate;
	}
	public void setExtraDataRate(double extraDataRate) {
		this.extraDataRate = extraDataRate;
	} 
    
     
}	   