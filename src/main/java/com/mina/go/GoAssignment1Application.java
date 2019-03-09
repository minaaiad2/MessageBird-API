package com.mina.go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mina.go.proxy.JobSchedule;

@SpringBootApplication (scanBasePackages = {"com.mina"})
@EnableScheduling
public class GoAssignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(GoAssignment1Application.class, args);

	}

}
