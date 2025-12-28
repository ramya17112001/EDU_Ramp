package com.assignment;

public class Complaint {
	 private static int nextId = 1;
	    private int complaintId;
	    private String message;

	    public Complaint(String message) {
	        this.complaintId = nextId++;
	        this.message = message;
	    }

	    @Override
	    public String toString() {
	        return "Complaint" + complaintId + ": " + message;
	    }

}
