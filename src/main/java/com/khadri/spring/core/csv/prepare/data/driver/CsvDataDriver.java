package com.khadri.spring.core.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khadri.spring.core.csv.prepare.data.config.AppConfig;
import com.khadri.spring.core.csv.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.spring.core.csv.prepare.data.customer.util.CustomerFileUtil;

import io.vavr.Tuple2;

public class CsvDataDriver {

	private static CustomerDataProcessor customerDataProcessor;
	private static Scanner scanner;
	private static CsvDataDriver csvDriver;

	{
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		scanner = (Scanner) applicationContext.getBean("scanner");

		customerDataProcessor = (CustomerDataProcessor) applicationContext.getBean("customerDataProcessor");

		// ((AnnotationConfigApplicationContext) applicationContext).close();
	}

	public static void main(String[] args) {
		csvDriver = new CsvDataDriver();

		System.out.println("###################### Welocme to CSV data Driver  ########################");
		System.out.println("$$$$$$$$$$$$$$ The data procesors $$$$$$$$$$$$$$$$$");

		Arrays.stream(DriverTypes.values()).forEach(each -> {
			System.out.println(each.getId() + " : " + each.getName());
		});

		csvDriver.process();
	}

	private void process() {
		System.out.println("Please choose the data processor : ");
		int dataProcessId = scanner.nextInt();

		switch (dataProcessId) {

		case 3:
			Tuple2<File, PrintWriter> tupleFilePW2 = CustomerFileUtil.customerCsvFilePrintWriter();

			try {
				System.out.println(" How many records you want to enter ?  : ");
				int records2 = scanner.nextInt();

				for (int i = 1; i <= records2; i++) {
					customerDataProcessor.process(tupleFilePW2._2, i);
				}
			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW2._2.flush();
				tupleFilePW2._2.close();
			}
			break;

		default:
			break;
		}

	}

}
