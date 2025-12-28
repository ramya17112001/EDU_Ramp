package TelecomProject;

import java.time.Duration;
import java.time.LocalDateTime;

public class CallLog {
	 private Customer caller;
	    private Customer receiver;
	    private LocalDateTime start;
	    private LocalDateTime end;

	    public CallLog(Customer caller, Customer receiver) {
	        this.caller = caller;
	        this.receiver = receiver;
	        this.start = LocalDateTime.now();
	    }

	    public void endCall() {
	        this.end = LocalDateTime.now();
	    }

	    public long getDurationInMinutes() {
	        return Duration.between(start, end).toMinutes();
	    }

	    public String toString() {
	        return "From: " + caller.getName() + " To: " + receiver.getName() + 
	                " Duration: " + getDurationInMinutes() + " mins";
	    }    

	    public Customer getCaller() { return caller; }
	}


