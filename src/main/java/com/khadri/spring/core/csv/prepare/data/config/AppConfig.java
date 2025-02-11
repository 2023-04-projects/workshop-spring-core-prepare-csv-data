package com.khadri.spring.core.csv.prepare.data.config;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.khadri.spring.core.csv.prepare.data.customer.processor.CustomerDataProcessor;

@Configuration
public class AppConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public File customerFile() {
		return new File("src/main/resources/customer.csv");
	}

	@Bean
	public PrintWriter printWriter(File file) throws Exception {
		FileWriter fileWriter = new FileWriter(file, true);
		return new PrintWriter(fileWriter);
	}

	@Bean
	public CustomerDataProcessor customerDataProcessor() {
		return new CustomerDataProcessor(scanner());
	}

}
