package com.tel_labs.ex2bonus.restController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tel_labs.ex2bonus.dataUtils.PlanDataUtil;
import com.tel_labs.ex2bonus.entity.Plan;
import com.tel_labs.ex2bonus.entity.PriceOutput;
import com.tel_labs.ex2bonus.service.PlanService;

@RestController
public class PlanController {

	private PlanService planService;

	@Autowired
	public PlanController(PlanService planService) {
		this.planService = planService;
	}

	@PostMapping("/api/plans")
	public String populatePlans(@RequestBody List<Plan> plans) {
		PlanDataUtil.generatePlanFeatureMap(plans);
		return "success";
	}

	@GetMapping("/api/plans")
	public PriceOutput getPlansByFeatures(@RequestParam String features) {
		List<String> featuresList = new ArrayList<>();

		if (features.length() > 0) {
			features = features.trim();
			String[] splits = features.split(",");

			for (String str : splits) {
				featuresList.add(str);
			}
		}

		if (featuresList.size() == 0) {
			return null;
		}
		return planService.generateOutput(featuresList);
	}
}
