package com.khadri.spring.core.csv.prepare.data.mobile.processor;

import java.io.PrintWriter;
import java.util.Scanner;

public class MobileDataProcessor {

	private Scanner scanner;

	public MobileDataProcessor(Scanner scanner) {
		this.scanner = scanner;
	}

	public void process(PrintWriter pw, int recordNumber) {

		System.out.println("===========> MOBILE " + recordNumber + " DATA READING STARTS ===========>");
		System.out.println("Enter MOBILE_ID : ");
		int id = scanner.nextInt();

		System.out.println("Enter MOBILE_NAME : ");
		String name = scanner.next();

		System.out.println("Enter MOBILE_PRICE : ");
		int price = scanner.nextInt();

		System.out.println("Processing MOBILE DATA");

		System.out.println("Processing MOBILE DETAILS");

		System.out.println("<=========== MOBILE " + recordNumber + " DATA READING ENDS <===========");

		System.out.println("===========> MOBILE" + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");

		// pw.println();// new empty row
		String line = id + "," + name + "," + price;

		pw.println(line);

		System.out.println();
		System.out.println("<=========== MOBILE " + recordNumber + " DATA WRITING INTO CSV File ENDS <===========");

	}

}
