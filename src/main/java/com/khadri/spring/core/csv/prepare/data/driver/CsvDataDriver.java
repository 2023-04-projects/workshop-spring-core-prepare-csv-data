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
import com.khadri.spring.core.csv.prepare.data.drivertypes.DriverTypes;
import com.khadri.spring.core.csv.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.spring.core.csv.prepare.data.employee.util.EmployeeFileUtil;
import com.khadri.spring.core.csv.prepare.data.movie.processor.MovieDataProcessor;
import com.khadri.spring.core.csv.prepare.data.movie.util.MovieFileUtil;
import com.khadri.spring.core.csv.prepare.data.supermarket.processor.SupermarketDataProcessor;
import com.khadri.spring.core.csv.prepare.data.supermarket.util.SuperMarketFileUtil;

import io.vavr.Tuple2;

public class CsvDataDriver {
	private static CustomerDataProcessor customerDataProcessor;
	private static EmployeeDataProcessor employeeDataProcessor;
	private static MovieDataProcessor movieDataProcessor;
	private static SupermarketDataProcessor superMarketDataProcessor;
	private static Scanner scanner;
	private static CsvDataDriver csvDriver;
	private static ApplicationContext applicationContext;

	{
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		scanner = applicationContext.getBean(Scanner.class);
		employeeDataProcessor = applicationContext.getBean(EmployeeDataProcessor.class);
		customerDataProcessor = applicationContext.getBean(CustomerDataProcessor.class);
		movieDataProcessor = applicationContext.getBean(MovieDataProcessor.class);
		superMarketDataProcessor = applicationContext.getBean(SupermarketDataProcessor.class);
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
		case 2:
			Tuple2<File, PrintWriter> tupleFilePW1 = EmployeeFileUtil.employeeCsvFilePrintWriter(applicationContext);
			try {
				System.out.println(" How many records you want to enter ?  : ");
				int records1 = scanner.nextInt();
				for (int i = 1; i <= records1; i++) {
					employeeDataProcessor.process(tupleFilePW1._2, i);
				}
			} catch (Exception e) {
				System.out.println("Exception Occured" + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW1._2.flush();
				tupleFilePW1._2.close();
			}
			break;

		case 3:

			Tuple2<File, PrintWriter> tupleFilePW2 = CustomerFileUtil.customerCsvFilePrintWriter(applicationContext);

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
			
		case 4:

			Tuple2<File, PrintWriter> tupleFilePW4 = SuperMarketFileUtil.superMarketCsvFilePrintWriter(applicationContext);

			try {
				System.out.println("How Many Records Do You Want ? : ");
				int records4 = scanner.nextInt();

				for (int i = 1; i <= records4; i++) {
					superMarketDataProcessor.process(tupleFilePW4._2, i);
				}

			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file.");
				
				tupleFilePW4._2.flush();
				tupleFilePW4._2.close();
			}

			break;


		case 5:
			MovieDataProcessor dataProcessor = new MovieDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW5 = MovieFileUtil.movieCsvFilePrintWriter(applicationContext);
			try {
				System.out.println(" How many records you want to enter ?  : ");
				int movieRecords = scanner.nextInt();

				for (int i = 0; i < movieRecords; i++) {
					dataProcessor.process(tupleFilePW5._2, i);

				}

			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW5._2.flush();
				tupleFilePW5._2.close();

			}

			break;

		default:
			break;
		}

		((AnnotationConfigApplicationContext) applicationContext).close();
	}

}
