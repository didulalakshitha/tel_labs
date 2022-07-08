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
		planFeatureMap.put("Plan0", new Plan("Plan0", 10, Arrays.asList("F7", "F0", "F1", "F3", "F2", "F6", "F9", "F8", "F4")));
		planFeatureMap.put("Plan1", new Plan("Plan1", 22, Arrays.asList("F6", "F8", "F4", "F3")));
		planFeatureMap.put("Plan2", new Plan("Plan2", 31, Arrays.asList("F5", "F8", "F0", "F3", "F1", "F2", "F7", "F9")));
		planFeatureMap.put("Plan3", new Plan("Plan3", 49, Arrays.asList("F9", "F8", "F5", "F0", "F2")));

		planFeatureMap.put("Plan4", new Plan("Plan4", 58, Arrays.asList("F3", "F8", "F1", "F0")));
		planFeatureMap.put("Plan5", new Plan("Plan5", 60, Arrays.asList("F7", "F4", "F8", "F0", "F1")));
		planFeatureMap.put("Plan6", new Plan("Plan6", 62, Arrays.asList("F6", "F7", "F4", "F9", "F3")));
		planFeatureMap.put("Plan7", new Plan("Plan7", 68, Arrays.asList("F6")));

		planFeatureMap.put("Plan8", new Plan("Plan8", 70, Arrays.asList("F9", "F7", "F8", "F6", "F4", "F2", "F3", "F1")));
		planFeatureMap.put("Plan9", new Plan("Plan9", 90, Arrays.asList("F2", "F9", "F4", "F3", "F1", "F6")));
		planFeatureMap.put("Plan10", new Plan("Plan10", 105, Arrays.asList("F5", "F4", "F8", "F0", "F1", "F6", "F9", "F2")));
		planFeatureMap.put("Plan11", new Plan("Plan11", 125, Arrays.asList("F8", "F6", "F4", "F0", "F3")));

		planFeatureMap.put("Plan12", new Plan("Plan12", 136, Arrays.asList("F5")));
		planFeatureMap.put("Plan13", new Plan("Plan13", 146, Arrays.asList("F6", "F9", "F1", "F0", "F7", "F4", "F2", "F8", "F5")));
		planFeatureMap.put("Plan14", new Plan("Plan14", 147, Arrays.asList("F7")));
		planFeatureMap.put("Plan15", new Plan("Plan15", 161, Arrays.asList("F2", "F6")));

		planFeatureMap.put("Plan16", new Plan("Plan16", 167, Arrays.asList("F1", "F7", "F9")));
		planFeatureMap.put("Plan17", new Plan("Plan17", 169, Arrays.asList("F7", "F4", "F8", "F6", "F9", "F1", "F3")));
		planFeatureMap.put("Plan18", new Plan("Plan18", 184, Arrays.asList("F7", "F9", "F4", "F8", "F0")));
		planFeatureMap.put("Plan19", new Plan("Plan19", 203, Arrays.asList("F6", "F7")));
	}

	public static void generatePlanFeatureMap(List<Plan> plans) {
		planFeatureMap.clear();

		for (Plan plan : plans) {
			planFeatureMap.put(plan.getPlan(), plan);
		}
	};
}
