package com.tel_labs.ex2.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tel_labs.ex2.entity.Plan;

public class DataGenerator {
    public DataGenerator() {

    }

    public Map<String, Plan> generatePlanFeatureMap(String fileName) throws Exception {
        BufferedReader reader = null;
        try {
            // reader = new BufferedReader(new FileReader("/home/didula/workspace_dlak/telepathy/example_2/Example1.txt"));
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            Map<String, Plan> planFeatureMap = new HashMap<>();

            while (line != null) {
                String[] splits = line.split(",");

                List<String> features = new ArrayList<>();
                if (splits.length > 2) {
                    for (int i = 2; i < splits.length; i++) {
                        features.add(splits[i].trim());
                    }
                }

                Plan plan = new Plan(splits[0], Integer.parseInt(splits[1].trim()), features);
                planFeatureMap.put(splits[0], plan);

                line = reader.readLine();
            }

            return planFeatureMap;
        } catch (Exception e) {
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<String> generateRequiredFeatureList(String featureString) {
        String[] splits = featureString.split(",");
        List<String> features = new ArrayList<>();

        for (String str : splits) {
            features.add(str);
        }

        return features;
    }
}
