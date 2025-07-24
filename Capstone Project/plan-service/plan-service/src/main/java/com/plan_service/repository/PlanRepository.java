package com.plan_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.plan_service.entity.Plan;
@Repository
public interface PlanRepository extends JpaRepository<Plan,Long>,JpaSpecificationExecutor<Plan >{
    
 
}  
 