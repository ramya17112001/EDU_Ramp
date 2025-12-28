package com.billing_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*; 
@Entity
@Table(name = "bills")
public class Bill {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Long userId; 
    private Double amount;
    private Date billDate;
    private String details;
 
    public Bill() {}

    public Bill(Long userId, Double amount, Date billDate, String details) {
        this.userId = userId;
        this.amount = amount;
        this.billDate = billDate;
        this.details = details; 
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}  

  
	}