package com.mini_project;

public class CallLog {
	String callerId;
    String receiverId;
    long startTime;
    long endTime;
 
    public CallLog(String callerId, String receiverId, long startTime, long endTime) {
        this.callerId = callerId;
        this.receiverId = receiverId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
 
    public long getDurationInMinutes() {
        return Math.max(1, (endTime - startTime) / 60000);
    }
 
    @Override
    public String toString() {
        return "Caller: " + callerId + ", Receiver: " + receiverId + ", Duration: " + getDurationInMinutes() + " mins";
    }
 

}
