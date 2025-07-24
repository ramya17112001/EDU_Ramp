package com.usage_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;  

@Entity
@Table(name = "usage_logs")
 
public class UsageLog {
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Long userId;
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date date;
	    private Integer callDuration;
	    private Double dataUsed;
	    private Integer smsCount;

	    public UsageLog() {}
	    
	    public UsageLog(Long userId, Date date, Integer callDuration, Double dataUsed, Integer smsCount) {
	        this.userId = userId;
	        this.date = date;
	        this.callDuration = callDuration;
	        this.dataUsed = dataUsed;
	        this.smsCount = smsCount;
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
	    
	}