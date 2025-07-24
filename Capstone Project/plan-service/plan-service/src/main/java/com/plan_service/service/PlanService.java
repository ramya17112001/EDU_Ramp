package com.plan_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.plan_service.dto.PlanDto;
import com.plan_service.dto.PlanFilterRequest;
import com.plan_service.dto.PlanRequest;
import com.plan_service.entity.Plan;
import com.plan_service.entity.PlanType;
import com.plan_service.exception.PlanNotFoundException;
import com.plan_service.repository.PlanRepository;
 
import lombok.RequiredArgsConstructor;

@Service

public class PlanService {
	 @Autowired
	    private PlanRepository planRepository;
	    @Autowired
	    private ModelMapper modelMapper;

	    public PlanDto addPlan(PlanRequest request) {
	        Plan p = new Plan(request.getName(), request.getType(), request.getPrice(), request.getValidity(), request.getFeatures());
	        return modelMapper.map(planRepository.save(p), PlanDto.class);
	    }

	    public List<PlanDto> getAllPlans(PlanFilterRequest filter) {
	        List<Plan> plans = planRepository.findAll((Specification<Plan>) (root, query, cb) -> {
	            var predicates = cb.conjunction();
	            if (filter.getType() != null) predicates = cb.and(predicates, cb.equal(root.get("type"), filter.getType()));
	            if (filter.getMinPrice() != null) predicates = cb.and(predicates, cb.ge(root.get("price"), filter.getMinPrice()));
	            if (filter.getMaxPrice() != null) predicates = cb.and(predicates, cb.le(root.get("price"), filter.getMaxPrice()));
	            if (filter.getMinValidity() != null) predicates = cb.and(predicates, cb.ge(root.get("validity"), filter.getMinValidity()));
	            return predicates;
	        });
	        return plans.stream().map(pl -> modelMapper.map(pl, PlanDto.class)).collect(Collectors.toList());
	    }

	    public PlanDto updatePlan(Long id, PlanRequest req) {
	        Plan plan = planRepository.findById(id)
	                .orElseThrow(() -> new PlanNotFoundException("Plan not found"));
	        plan.setName(req.getName());
	        plan.setType(req.getType());
	        plan.setPrice(req.getPrice());
	        plan.setValidity(req.getValidity());
	        plan.setFeatures(req.getFeatures());
	         return modelMapper.map(planRepository.save(plan), PlanDto.class);
	    }
  
	    public void deletePlan(Long id) {
	        if (!planRepository.existsById(id)) {
	            throw new PlanNotFoundException("Plan not found");
	        }
	        planRepository.deleteById(id);
	    } 
	}