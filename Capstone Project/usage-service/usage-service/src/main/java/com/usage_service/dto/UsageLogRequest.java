package com.usage_service.dto;
import java.util.Date;

import jakarta.validation.constraints.*;
import lombok.*;

public class UsageLogRequest {
	
	public UsageLogRequest() {}
	
	 private Long userId;
	    private Date date;
	    private Integer callDuration;
	    private Double dataUsed;
	    private Integer smsCount;
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
		public UsageLogRequest(Long userId, Date date, Integer callDuration, Double dataUsed, Integer smsCount) {
			super();
			this.userId = userId;
			this.date = date;
			this.callDuration = callDuration;
			this.dataUsed = dataUsed;
			this.smsCount = smsCount;
		}
	     
}