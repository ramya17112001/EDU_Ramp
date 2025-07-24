package com.billing_service.strategy;

import com.billing_service.dto.Plan;
import com.billing_service.dto.Usage;

public interface BillingStrategy {
	double calculateBill(Usage usage, Plan plan);
	 
}   
