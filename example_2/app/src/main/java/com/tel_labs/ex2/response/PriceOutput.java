package com.tel_labs.ex2.response;

public class PriceOutput {
    private int price = 0;
    private String[] plans = new String[0];

    public PriceOutput(int price, String[] plans) {
      this.price = price;
      this.plans = plans;
    }

    public int getPrice() {
      return price;
    }

    public void setPrice(int price) {
      this.price = price;
    }

    public String[] getPlans() {
      return plans;
    }

    public void setPlans(String[] plans) {
      this.plans = plans;
    }
}
