package com.billing_service;

import com.billing_service.dto.Plan;
import com.billing_service.dto.Usage;

public abstract class BillingTemplate {
	public double generate(Usage usage, Plan plan) {
        preProcess(usage, plan);
        double amount = calculateAmount(usage, plan);
        postProcess(amount);
        return amount;
    }
    protected void preProcess(Usage usage, Plan plan) {
        
    }
    protected abstract double calculateAmount(Usage usage, Plan plan);
    protected void postProcess(double amount) {
         
    }
 
}
 