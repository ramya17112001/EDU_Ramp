package com.user_service.dto;

public class PlanUsageDto {
	 private Long userId;
	    private Long planId;
	    private String planName;
	    private Double totalUsage;  

	    public PlanUsageDto() {}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Long getPlanId() {
			return planId;
		}

		public void setPlanId(Long planId) {
			this.planId = planId;
		}

		public String getPlanName() {
			return planName;
		}

		public void setPlanName(String planName) {
			this.planName = planName;
		}

		public Double getTotalUsage() {
			return totalUsage;
		}

		public void setTotalUsage(Double totalUsage) {
			this.totalUsage = totalUsage;
		}

		public PlanUsageDto(Long userId, Long planId, String planName, Double totalUsage) {
			super();
			this.userId = userId;
			this.planId = planId;
			this.planName = planName;
			this.totalUsage = totalUsage;
		}
	      
	    // Getters and setters
	}
	