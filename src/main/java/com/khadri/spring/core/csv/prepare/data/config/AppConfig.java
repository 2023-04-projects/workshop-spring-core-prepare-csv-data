package com.khadri.spring.core.csv.prepare.data.config;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public PrintWriter printWriter(File file) throws Exception {
		FileWriter fileWriter = new FileWriter(file, true);
		return new PrintWriter(fileWriter);
	}
}
