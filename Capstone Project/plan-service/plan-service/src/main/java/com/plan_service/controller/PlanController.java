package com.plan_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


//import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plan_service.dto.PlanDto;
import com.plan_service.dto.PlanFilterRequest;
import com.plan_service.dto.PlanRequest;
import com.plan_service.service.PlanService;
import com.plan_service.service.PlanService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plans")
 
public class PlanController {
	@Autowired
    private PlanService planService;

    @PostMapping
    public PlanDto addPlan(@RequestBody PlanRequest req) {
        return planService.addPlan(req);
    }

    @GetMapping
    public List<PlanDto> getPlans(@RequestParam(required = false) String type,
                                  @RequestParam(required = false) Double minPrice,
                                  @RequestParam(required = false) Double maxPrice,
                                  @RequestParam(required = false) Integer minValidity) {
        PlanFilterRequest filter = new PlanFilterRequest();
        filter.setType(type); filter.setMinPrice(minPrice);
        filter.setMaxPrice(maxPrice); filter.setMinValidity(minValidity);
        return planService.getAllPlans(filter);
    }

    @PutMapping("/{id}") 
    public PlanDto updatePlan(@PathVariable Long id, @RequestBody PlanRequest req) {
        return planService.updatePlan(id, req);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
    }
} 