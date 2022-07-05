package com.tel_labs.ex2.entity;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private String plan = null;
    private int price = 0;
    private List<String> features = new ArrayList<>();

    public Plan(String plan, int price, List<String> features) {
        this.plan = plan;
        this.price = price;
        this.features = features;
    }

    public String getPlan() {
      return plan;
    }

    public void setPlan(String plan) {
      this.plan = plan;
    }

    public int getPrice() {
      return price;
    }

    public void setPrice(int price) {
      this.price = price;
    }

    public List<String> getFeatures() {
      return features;
    }

    public void setFeatures(List<String> features) {
      this.features = features;
    }

    public boolean isFeatureExist(String featureName) {
      return this.features.contains(featureName);
    }
}
