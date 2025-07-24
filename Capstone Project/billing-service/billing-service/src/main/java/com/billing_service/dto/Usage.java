package com.billing_service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Usage {
	private Long userId;
	@JsonFormat(pattern="yyyy-mm-dd")
    private Date date; 
    private int callDuration;
    private double dataUsed; 
    private int smsCount;
    public Usage() {}
    public Usage(Long userId, Date date, int callDuration, double dataUsed, int smsCount) {
        this.userId = userId; this.date = date; this.callDuration = callDuration;
        this.dataUsed = dataUsed; this.smsCount = smsCount;
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
	public int getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}
	public double getDataUsed() {
		return dataUsed;
	}
	public void setDataUsed(double dataUsed) {
		this.dataUsed = dataUsed;
	}
	public int getSmsCount() {
		return smsCount;
	}
	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	 
     
}
}
