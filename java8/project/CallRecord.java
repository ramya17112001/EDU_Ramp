package com.java8.project;

import java.time.Duration;
import java.time.LocalDateTime;

public class CallRecord {
	private String customerId;
    private String operator;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CallRecord(String customerId, String operator, String location, LocalDateTime startTime, LocalDateTime endTime) {
        this.customerId = customerId;
        this.operator = operator;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOperator() {
        return operator;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public long getDurationSeconds() {
        return Duration.between(startTime, endTime).getSeconds();
    }

    @Override
    public String toString() {
        return "CallRecord{" +
                "customerId='" + customerId + '\'' +
                ", operator='" + operator + '\'' +
                ", location='" + location + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", durationSeconds=" + getDurationSeconds() +
                '}';
    }
} 
 