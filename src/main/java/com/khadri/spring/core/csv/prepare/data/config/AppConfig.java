package com.khadri.spring.core.csv.prepare.data.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
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

	@Bean("customerFile")
	public File customerFile() {
		String path = "src/main/resources/customer.csv";
		return new File(path);
	}

	@Bean("employeeFile")
	public File employeeFile() {
		String path = "src/main/resources/employee.csv";
		return new File(path);
	}

	@Bean
	public EmployeeDataProcessor employeeDataProcessor() {
		return new EmployeeDataProcessor(scanner());
	}

	@Bean
	public PrintWriter printWriterEmployee(@Qualifier("employeeFile") File employeeFile) throws IOException {
		FileWriter fileWriter = new FileWriter(employeeFile, true);
		return new PrintWriter(fileWriter);
	}

	@Bean
	public PrintWriter printWriterCustomer(@Qualifier("customerFile") File customerFile) throws Exception {
		FileWriter fileWriter = new FileWriter(customerFile, true);
		return new PrintWriter(fileWriter);
	}

	@Bean
	public CustomerDataProcessor customerDataProcessor() {
		return new CustomerDataProcessor(scanner());
	}

}
