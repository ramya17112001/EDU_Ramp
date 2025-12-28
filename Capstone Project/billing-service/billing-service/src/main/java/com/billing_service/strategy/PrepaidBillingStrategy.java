package com.billing_service.strategy;

import org.springframework.stereotype.Component;

import com.billing_service.dto.Plan;
import com.billing_service.dto.Usage;
@Component("prepaidBillingStrategy")
public class PrepaidBillingStrategy implements BillingStrategy {
    @Override
    public double calculateBill(Usage usage, Plan plan) {
        double total = plan.getPrice();
        double extraData = Math.max(0, usage.getDataUsed() - plan.getIncludedData());
        double extraCharge = extraData * plan.getExtraDataRate();
        return total + extraCharge;
    }
  
} 
  