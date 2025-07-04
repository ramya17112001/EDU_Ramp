package TelecomProject;

public class PostpaidPlan extends Plan {
    public PostpaidPlan() {
        this.ratePerMinute = 1.0;
    }
 
    public String getType() {
        return "Postpaid";
    } 
 
}
