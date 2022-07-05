package com.tel_labs.ex2bonus.dataUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tel_labs.ex2bonus.entity.Plan;

@Service
public class PlanDataUtil {
	public static Map<String, Plan> planFeatureMap = new HashMap<>();
	
	public static void prePopulateData() {
		planFeatureMap.clear();
		planFeatureMap.put("PLAN1", new Plan("PLAN1", 100, Arrays.asList("voice", "email")));
		planFeatureMap.put("PLAN2", new Plan("PLAN2", 100, Arrays.asList("email", "database", "admin")));
		planFeatureMap.put("PLAN3", new Plan("PLAN3", 100, Arrays.asList("voice", "admin")));
		planFeatureMap.put("PLAN4", new Plan("PLAN4", 100, Arrays.asList("database", "admin")));
	}
	
	public static void generatePlanFeatureMap(List<Plan> plans) {
		planFeatureMap.clear();
		
		for (Plan plan : plans) {
			planFeatureMap.put(plan.getPlan(), plan);
		}
	};
}
