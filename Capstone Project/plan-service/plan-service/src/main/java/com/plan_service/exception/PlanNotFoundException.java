package com.plan_service.exception;
public class PlanNotFoundException extends RuntimeException{
public PlanNotFoundException(String msg) {
    super("Plan not found: " + msg);
} 

    
}
