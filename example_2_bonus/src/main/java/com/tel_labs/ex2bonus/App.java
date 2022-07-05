package com.tel_labs.ex2bonus;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tel_labs.ex2bonus.dataUtils.PlanDataUtil;

@SpringBootApplication
public class App {
	
    @PostConstruct
    public void postConstruct(){
    	PlanDataUtil.prePopulateData();
    }

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


}
