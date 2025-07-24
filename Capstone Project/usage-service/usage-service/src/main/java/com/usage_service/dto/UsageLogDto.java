package com.usage_service.dto;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class UsageLogDto {
	private Long id;
    private Long userId;
    private Date date;
    private Integer callDuration;
    private Double dataUsed;
    private Integer smsCount;
    public UsageLogDto() {}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(Integer callDuration) {
		this.callDuration = callDuration;
	}
	public Double getDataUsed() {
		return dataUsed;
	}
	public void setDataUsed(Double dataUsed) {
		this.dataUsed = dataUsed;
	}
	public Integer getSmsCount() {
		return smsCount;
	}
	public void setSmsCount(Integer smsCount) {
		this.smsCount = smsCount;
	}
	public UsageLogDto(Long id, Long userId, Date date, Integer callDuration, Double dataUsed, Integer smsCount) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.callDuration = callDuration;
		this.dataUsed = dataUsed;
		this.smsCount = smsCount;
	}
    
}