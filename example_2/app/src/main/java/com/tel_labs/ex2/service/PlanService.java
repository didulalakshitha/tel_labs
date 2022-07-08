package com.tel_labs.ex2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tel_labs.ex2.entity.Plan;
import com.tel_labs.ex2.response.PriceOutput;

public class PlanService {
    private static Map<String, Plan> planFeatureMap = new HashMap<>();

    public PlanService() {
    }

    public static void setPlanFeatureMap(Map<String, Plan> planFeatureMap) {
      PlanService.planFeatureMap = planFeatureMap;
    }

    private Set<String> findCombinationsOfPlans(List<String> requiredFeatures) {
    	Map<String, List<String>> featurePlansMap = new HashMap<String, List<String>>();
    	for (String requiredFeatureName : requiredFeatures) {
    		List<String> plansListsByFeature = new ArrayList<>();
    		for (String planFeatureMapKey : planFeatureMap.keySet()) {
    			Plan plan = planFeatureMap.get(planFeatureMapKey);
    			if (plan.isFeatureExist(requiredFeatureName)) {
    				plansListsByFeature.add(planFeatureMapKey);
    			}
    		}
    		featurePlansMap.put(requiredFeatureName, plansListsByFeature);
    	}

    	Set<String> plansListStrMap = new HashSet<>();

    	for (String featurePlansMap_featureKey : featurePlansMap.keySet()) {
    		Set<String> combinations = new HashSet<>();

    		List<String> featurePlansMap_plansValue = featurePlansMap.get(featurePlansMap_featureKey);

    		if (plansListStrMap.isEmpty()) {
    			combinations = new HashSet<>(featurePlansMap_plansValue);
    		} else {
    			for (String planValue : featurePlansMap_plansValue) {
            		for (String str : plansListStrMap) {
            			String[] strArr = str.split(",");
            			Set<String> combiSetOfPlans = new HashSet<>(Arrays.asList(strArr));
            			combiSetOfPlans.add(planValue);

            			String[] arr = combiSetOfPlans.stream().toArray(String[]::new);
            			Arrays.sort(arr);

            			String tempStr = String.join(",", arr);

            			combinations.add(tempStr);
            		}
    			}
    		}

    		plansListStrMap = combinations;
    	}

    	return plansListStrMap;
    }

    public PriceOutput generateOutput(List<String> requiredFeatures) {
    	Set<String> combinations = findCombinationsOfPlans(requiredFeatures);
	    String[] foundPlans = new String[0];
	    int foundMinPrice = 0;

	    for (String plansStr : combinations) {
	    	String[] strArr = plansStr.split(",");
	    	int price = 0;

	    	for (String planName : strArr) {
	    		Plan plan = planFeatureMap.get(planName);
	    		price = price + plan.getPrice();
	    	}

			if (foundMinPrice == 0 || foundMinPrice > price) {
				foundMinPrice = price;
			    foundPlans = strArr;
			}
	    }

        if (foundPlans.length > 0) {
            Arrays.sort(foundPlans);
            return new PriceOutput(foundMinPrice, foundPlans);
        }

        return null;
    }
}
