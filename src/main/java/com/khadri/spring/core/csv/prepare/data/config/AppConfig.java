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
import com.khadri.spring.core.csv.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.spring.core.csv.prepare.data.movie.processor.MovieDataProcessor;

@Configuration
public class AppConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean("mobileFile")
	public File mobileFile() {
		String path = "src/main/resources/mobile.csv";
		return new File(path);
	}

	@Bean("employeeFile")
	public File employeeFile() {
		String path = "src/main/resources/employee.csv";
		return new File(path);
	}

	@Bean("customerFile")
	public File customerFile() {
		String path = "src/main/resources/customer.csv";
		return new File(path);
	}

	@Bean("movieFile")
	public File movieFile() {
		String movieFilePath = "src/main/resources/movie.csv";
		return new File(movieFilePath);
	}

	@Bean
	public PrintWriter printWriterMobile(@Qualifier("mobileFile") File mobileFile) throws Exception {
		FileWriter fileWriter = new FileWriter(mobileFile, true);
		return new PrintWriter(fileWriter);
	}

	@Bean
	public PrintWriter printWriterEmployee(@Qualifier("employeeFile") File employeeFile) throws IOException {
		FileWriter fileWriter = new FileWriter(employeeFile, true);
		return new PrintWriter(fileWriter);
	}

	@Bean
	public PrintWriter printWriterMovie(@Qualifier("movieFile") File movieFile) throws IOException {
		FileWriter fileWriter = new FileWriter(movieFile, true);
		return new PrintWriter(fileWriter);
	}

	public PrintWriter printWriterCustomer(@Qualifier("customerFile") File customerFile) throws IOException {
		FileWriter fileWriter = new FileWriter(customerFile, true);
		return new PrintWriter(fileWriter);
	}

	@Bean
	public MobileDataProcessor mobileDataProcessor() {
		return new MobileDataProcessor(scanner());
	}

	@Bean
	public EmployeeDataProcessor employeeDataProcessor() {
		return new EmployeeDataProcessor(scanner());
	}

	@Bean
	public CustomerDataProcessor customerDataProcessor() {
		return new CustomerDataProcessor(scanner());
	}

	@Bean
	public MovieDataProcessor movieDataProcessor() {
		return new MovieDataProcessor(scanner());
	}
}
