package com.khadri.spring.core.csv.prepare.data.config;

import java.io.File;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.khadri.spring.core.csv.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.spring.core.csv.prepare.data.employee.processor.EmployeeDataProcessor;

@Configuration
public class AppConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public File employeeFile() {
		return new File("src/main/resources/employee.csv");
	}

	@Bean
	public EmployeeDataProcessor employeeDataProcessor() {
		return new EmployeeDataProcessor(scanner());
	}

	@Bean
	public File customerFile() {
		return new File("src/main/resources/customer.csv");
	}

	@Bean
	public CustomerDataProcessor customerDataProcessor() {
		return new CustomerDataProcessor(scanner());
	}

}
