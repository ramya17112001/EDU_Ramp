package com.plan_service.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder; 
import lombok.Data;
import lombok.*; 
import lombok.NoArgsConstructor;
 
@Entity 
@Table(name="plans")

public class Plan {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	    private String name;
	    private String type; // e.g., POSTPAID, PREPAID, DATA_ONLY
	    private Double price;
	    private Integer validity; // Days
	    private String features; // JSON, CSV, or plain text

	    public Plan() {}
	    public Plan(String name, String type, Double price, Integer validity, String features) {
	        this.name = name;
	        this.type = type;
	        this.price = price;
	        this.validity = validity; 
	        this.features = features;
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
	      
	    // Getters & Setters...
	}