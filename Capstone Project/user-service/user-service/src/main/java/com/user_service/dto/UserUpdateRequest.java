package com.user_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserUpdateRequest {
	 private String name;
	    private String phone;
	    private Long planId;

	    public UserUpdateRequest() {}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Long getPlanId() {
			return planId;
		}

		public void setPlanId(Long planId) {
			this.planId = planId;
		}

		public UserUpdateRequest(String name, String phone, Long planId) {
			super();
			this.name = name;
			this.phone = phone;
			this.planId = planId;
		}
	     
	}