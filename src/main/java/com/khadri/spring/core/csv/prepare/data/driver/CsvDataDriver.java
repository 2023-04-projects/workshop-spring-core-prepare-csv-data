package com.khadri.spring.core.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khadri.spring.core.csv.prepare.data.config.AppConfig;
import com.khadri.spring.core.csv.prepare.data.driver.types.DriverTypes;
import com.khadri.spring.core.csv.prepare.data.supermarket.processor.SupermarketDataProcessor;
import com.khadri.spring.core.csv.prepare.data.supermarket.util.SuperMarketFileUtil;

import io.vavr.Tuple2;

public class CsvDataDriver {

	private Scanner scanner;
	private SupermarketDataProcessor superMarketDataProcessor;

	public static void main(String[] args) {

		CsvDataDriver csvDataDriver = new CsvDataDriver();
		csvDataDriver.process();
	}

	private void process() {
		// Activation of Container : BeanFactory or ApplicationContext Container

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		scanner = applicationContext.getBean(Scanner.class);

		superMarketDataProcessor = applicationContext.getBean(SupermarketDataProcessor.class);

		System.out.println("###################### Welocme to CSV data Driver  ########################");
		System.out.println("$$$$$$$$$$$$$$ The data procesors $$$$$$$$$$$$$$$$$");

		Arrays.stream(DriverTypes.values()).forEach(each -> {
			System.out.println(each.getId() + " : " + each.getName());
		});

		System.out.println("Please choose the data processor : ");
		int dataProcessId = scanner.nextInt();

		switch (dataProcessId) {
		case 4:

			Tuple2<File, PrintWriter> tupleFilePW4 = SuperMarketFileUtil
					.superMarketCsvFilePrintWriter(applicationContext);

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
		default:
			break;
		}
		scanner.close();
		applicationContext.close();

	}
}
