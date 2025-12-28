package TelecomProject;

public class PrepaidPlan extends Plan {
    public PrepaidPlan() {
        this.ratePerMinute = 0.5;
    }

    public String getType() {
        return "Prepaid";
    } 

} 
