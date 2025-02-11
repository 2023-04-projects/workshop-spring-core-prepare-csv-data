package com.khadri.spring.core.csv.prepare.data.customer.processor;

import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerDataProcessor {
	private Scanner scanner;

	public CustomerDataProcessor(Scanner scanner) {
		this.scanner = scanner;
	}

	public void process(PrintWriter pw, int recordNumber) {
		System.out.println("===========> CUSTOMER " + recordNumber + " DATA READING STARTS ===========>");
		System.out.println("Enter Cust_Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Customer Name : ");
		String name = scanner.next();

		System.out.println("Enter  Customer Address : ");
		String address = scanner.next();

		System.out.println("Enter Customer Phone_Num : ");
		Long phone_Num = scanner.nextLong();

		System.out.println("<=========== CUSTOMER " + recordNumber + " DATA READING ENDS <===========");

		System.out.println("===========> CUSTOMER " + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");

		String line = id + "," + name + "," + address + "," + phone_Num;
		pw.println(line);

		System.out.println("<=========== CUSTOMER " + recordNumber + " DATA WRITING INTO CSV File ENDS <===========");

	}
}
