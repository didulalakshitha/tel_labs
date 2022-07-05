package com.tel_labs.ex2bonus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tel_labs.ex2bonus.dataUtils.PlanDataUtil;
import com.tel_labs.ex2bonus.entity.Plan;
import com.tel_labs.ex2bonus.entity.PriceOutput;

@Service
public class PlanService {

    public PlanService() {
    }

    private List<Set<String>> findCombinationsOfPlans(List<String> requiredFeatures) {
    	Map<String, Plan> planFeatureMap = PlanDataUtil.planFeatureMap;
    	
        List<Set<String>> combinations = new ArrayList<>();

        for (String requiredFeatureName : requiredFeatures) {
            List<Set<String>> newCombinations = new ArrayList<>();

            for (String planFeatureMapKey : planFeatureMap.keySet()) {
                Plan plan = planFeatureMap.get(planFeatureMapKey);
                if (plan.isFeatureExist(requiredFeatureName)) {
                    if (combinations.size() == 0) {
                        Set<String> tempSet = new HashSet<>();
                        tempSet.add(planFeatureMapKey);
                        newCombinations.add(tempSet);
                    } else {
                        for (Set<String> combinationSet : combinations) {
                            Set<String> temp = new HashSet<>(combinationSet);
                            temp.add(planFeatureMapKey);
                            newCombinations.add(temp);
                        }
                    }
                }
            }

            combinations = newCombinations;
        }

        return combinations;
    }

    public PriceOutput generateOutput(List<String> requiredFeatures) {
    	Map<String, Plan> planFeatureMap = PlanDataUtil.planFeatureMap;
    	
        List<Set<String>> combinations = findCombinationsOfPlans(requiredFeatures);

        String[] foundPlans = new String[0];
        int foundMinPrice = 0;
        for (Set<String> combination : combinations) {
            int price = 0;
            for (String planName : combination) {
                Plan plan = planFeatureMap.get(planName);
                price = price + plan.getPrice();
            }

            if (foundMinPrice == 0 || foundMinPrice > price) {
                foundMinPrice = price;
                foundPlans = combination.stream().toArray(String[]::new);
            }
        }

        if (foundPlans.length > 0) {
            Arrays.sort(foundPlans);
            return new PriceOutput(foundMinPrice, foundPlans);
        }
        return null;
    }
}
