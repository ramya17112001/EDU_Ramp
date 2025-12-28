package com.billing_service.repository;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing_service.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
 	 //Optional<Bill> findByUserIdAndBillingMonth(String userId, YearMonth month);
	    List<Bill> findByUserId(Long userId);
}  
     
