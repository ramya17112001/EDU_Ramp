package TelecomProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CallManager {
	private static CallManager instance = null;
    private Map<Customer, List<CallLog>> callRecords = new ConcurrentHashMap<>();

    private CallManager() {} 
 
    public static synchronized CallManager getInstance() {
        if (instance == null) {
            instance = new CallManager();
        }
        return instance;
    }

    public void simulateCall(Customer caller, Customer receiver, int durationSeconds) {
        CallLog log = new CallLog(caller, receiver);
        new Thread(() -> {
            try {
                Thread.sleep(durationSeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.endCall();
            callRecords.computeIfAbsent(caller, k -> new ArrayList<>()).add(log);
            System.out.println("[CALL ENDED] " + log);
        }).start();
    }

    public List<CallLog> getLogs(Customer customer) {
        return callRecords.getOrDefault(customer, Collections.emptyList());
    }

    public Map<Customer, List<CallLog>> getAllLogs() {
        return callRecords; 
    }
}



