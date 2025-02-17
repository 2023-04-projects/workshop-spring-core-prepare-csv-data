package com.khadri.spring.core.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khadri.spring.core.csv.prepare.data.config.AppConfig;
import com.khadri.spring.core.csv.prepare.data.drivertypes.DriverTypes;
import com.khadri.spring.core.csv.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.spring.core.csv.prepare.data.mobile.util.MobileFileUtil;

import io.vavr.Tuple2;

public class CsvDataDriver {

	private static MobileDataProcessor mobileDataProcessor;

	private static Scanner scanner;
	private static CsvDataDriver csvDriver;
	private static ApplicationContext applicationContext;

	{
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		scanner = (Scanner) applicationContext.getBean("scanner");
		mobileDataProcessor = (MobileDataProcessor) applicationContext.getBean("mobileDataProcessor");
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
		case 6:
			MobileDataProcessor mobileProcessor = new MobileDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW6 = MobileFileUtil.mobileCsvFilePrintWriter(applicationContext);

			try {
				System.out.println(" How many records you want to enter ?  : ");
				int records = scanner.nextInt();

				for (int i = 1; i <= records; i++) {
					mobileProcessor.process(tupleFilePW6._2, i);
				}
			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW6._2.flush();
				tupleFilePW6._2.close();
			}

			break;
		default:
			break;

		}
		((AnnotationConfigApplicationContext) applicationContext).close();
	}
}
