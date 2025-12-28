package TelecomProject;

public class Customer {
	 private int id;
	    private String name;
	    private Plan plan;

	    public Customer(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public void setPlan(Plan plan) {
	        this.plan = plan;
	    }

	    public Plan getPlan() {
	        return plan;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    @Override
	    public String toString() {
	        return id + " - " + name + " (" + plan.getType() + ")";
	    }
 
}
