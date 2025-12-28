package TelecomProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BillingEngine {
	private static BillingEngine instance;
    private final List<NotificationService> observers = new ArrayList<>();

    private BillingEngine() {}

    public static BillingEngine getInstance() {
        if (instance == null) instance = new BillingEngine();
        return instance;
    }

    public void addObserver(NotificationService observer) {
        observers.add(observer);
    } 

    public void generateBills(Map<Customer, List<CallLog>> logs) {
        for (Map.Entry<Customer, List<CallLog>> entry : logs.entrySet()) {
            Customer customer = entry.getKey();
            List<CallLog> calls = entry.getValue();
            double total = 5.0;
            for (CallLog c : calls) {
                total += c.getDurationInMinutes() * customer.getPlan().getRatePerMinute();
            }
            String report = "Bill for " + customer.getName() + ": $" + total;
            notifyObservers(report);
        }
    }
 
    private void notifyObservers(String message) {
        for (NotificationService obs : observers) {
            obs.notify(message);
        }
    }
}
