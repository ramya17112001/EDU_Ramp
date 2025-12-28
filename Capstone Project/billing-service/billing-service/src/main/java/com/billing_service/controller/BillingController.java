package com.billing_service.controller;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billing_service.dto.Plan;
import com.billing_service.dto.Usage;
import com.billing_service.dto.User;
import com.billing_service.entity.Bill;

import com.billing_service.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {
	@Autowired
    private BillingService billingService;

    @PostMapping("/generate/{userId}")
    public Bill generateBill(@PathVariable Long userId) {
        return billingService.generateBill(userId);
    }

    @GetMapping("/history")
    public List<Bill> getBillingHistory(@RequestParam Long userId) {
        return billingService.getBillingHistory(userId);
    }

    @GetMapping("/{billId}")
    public Bill getBill(@PathVariable Long billId) {
        return billingService.getBillById(billId);
    }
    @GetMapping("/history/all")
  public List<Bill> getAllBillingHistory() {
      return billingService.getAllBills();
 }
// 
   
}
