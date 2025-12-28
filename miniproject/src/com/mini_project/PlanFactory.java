
package com.mini_project;

public class PlanFactory {
	public static Plan getPlan(PlanType type) {
        switch (type) {
            case PREPAID: return new PrepaidPlan();
            case POSTPAID: return new PostpaidPlan();
            default: throw new IllegalArgumentException("Invalid plan type");
        }
    } 

}
