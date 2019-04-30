package com.shadowphoenix.fontys.testworkshop;

import com.shadowphoenix.fontys.testworkshop.user.UserData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWorkshopApplication.class, args);
		UserData.loadUserData();
	}

}
