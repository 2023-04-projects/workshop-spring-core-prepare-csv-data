package com.khadri.spring.core.csv.prepare.data.config;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.khadri.spring.core.csv.prepare.data.driver.CsvDataDriver;
import com.khadri.spring.core.csv.prepare.data.supermarket.processor.SupermarketDataProcessor;

@Configuration
public class AppConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public SupermarketDataProcessor superMarketDataProcessor(Scanner scanner) {
		return new SupermarketDataProcessor(scanner);
	}

	@Bean
	public File file() {
		
		File file = new File("src/main/resources/supermarket.csv");
		
		return file;
		
	}

	@Bean
	public PrintWriter printWriter(File file) throws Exception {
		FileWriter fileWriter = new FileWriter(file, true);
		return new PrintWriter(fileWriter);
	}

}
