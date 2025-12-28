package com.billing_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.billing_service.dto.Plan;
import com.billing_service.dto.Usage;
import com.billing_service.dto.User;
//import com.billing_service.dto.BillSummaryDto;
import com.billing_service.entity.Bill;
import com.billing_service.exception.BillNotFoundException;
import com.billing_service.observer.EmailObserver;
import com.billing_service.observer.NotificationObserver;
import com.billing_service.observer.SMSObserver;
//import com.billing_service.dto.BillSummaryDto;
//import com.billing_service.entity.Bill;
//import com.billing_service.exception.BillNotFoundException;
// import com.billing_service.exception.BillingNotFoundException;
import com.billing_service.repository.BillRepository;
import com.billing_service.strategy.BillingStrategy;

@Service
public class BillingService {
	 @Autowired
	    private BillRepository billRepository;

	    @Autowired
	     @Qualifier("prepaidBillingStrategy")
	    private BillingStrategy prepaidStrategy;

	   
	    private final List<NotificationObserver> observers = Arrays.asList(new EmailObserver(), new SMSObserver());
 
	    public Bill generateBill(Long userId) {
	         User user = new User(userId, "User" + userId);
	        Plan plan = new Plan(1L, "Smart Prepaid", "PREPAID", 200.0, 28, 1000, 1.5);
	         Usage usage = new Usage(userId, new Date(), 120, 1200, 10);

	        double billAmount = prepaidStrategy.calculateBill(usage, plan);
    
	        Bill bill = new Bill(userId, billAmount, new Date(), "Monthly bill generated");
	        Bill saved = billRepository.save(bill);

	        String msg = String.format("Dear %s, your bill of Rs.%.2f generated.", user.getName(), billAmount);
	        for (NotificationObserver obs : observers) {
	            obs.notify(userId, msg);  
	        }
	        return saved;
	    }

	    public List<Bill> getBillingHistory(Long userId) {
	        return billRepository.findByUserId(userId);
	    }
	    public List<Bill> getAllBills() {
	        return billRepository.findAll();
	    } 


	    public Bill getBillById(Long billId) {
	        return billRepository.findById(billId)
	                .orElseThrow(() -> new RuntimeException("Bill not found"));
	    }
	}
 