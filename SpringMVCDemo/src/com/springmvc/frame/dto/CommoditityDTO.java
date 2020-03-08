package com.springmvc.frame.dto;

import com.springmvc.frame.service.CommoditityService;

public class CommoditityDTO {
	
	private CommoditityService commoditityService;

	public CommoditityDTO(CommoditityService commoditityService) {
		super();
		this.commoditityService = commoditityService;
	}

	public CommoditityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommoditityService getCommoditityService() {
		return commoditityService;
	}

	public void setCommoditityService(CommoditityService commoditityService) {
		this.commoditityService = commoditityService;
	}
	
	
	
}
