package com.plan_service.dto;

import java.math.BigDecimal;

import lombok.Data;


public class PlanRequest {
	private String name;
    private String type;
    private Double price;
    private Integer validity;
    private String features;
    
    
	public PlanRequest(String name, String type, Double price, Integer validity, String features) {
		super();
		this.name = name;
		this.type = type;
	 	this.price = price;
		this.validity = validity;
		this.features = features;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	
      
}