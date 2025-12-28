package com.plan_service.dto;

public class PlanFilterRequest {
	private String type;
    private Double minPrice;
    private Double maxPrice;
     private Integer minValidity;

    public PlanFilterRequest() {}

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getMinPrice() { return minPrice; }
    public void setMinPrice(Double minPrice) { this.minPrice = minPrice; }

    public Double getMaxPrice() { return maxPrice; }
    public void setMaxPrice(Double maxPrice) { this.maxPrice = maxPrice; }

    public Integer getMinValidity() { return minValidity; }
    public void setMinValidity(Integer minValidity) { this.minValidity = minValidity; }
}
  