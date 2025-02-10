package com.khadri.spring.core.csv.prepare.data.supermarket.processor;

import java.io.PrintWriter;
import java.util.Scanner;

public class SupermarketDataProcessor {
	
	private Scanner scanner;

    // Constructor that Spring will use for dependency injection
    public SupermarketDataProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void process(PrintWriter pw, int recordNumber) {

        System.out.println("===========> SUPERMARKET " + recordNumber + " DATA READING STARTS ===========>");

        System.out.println("Enter Product Name : ");
        String prodName = scanner.next();

        System.out.println("Enter Product Id : ");
        int prodId = scanner.nextInt();

        System.out.println("Enter Product Price: ");
        double prodPrice = scanner.nextDouble();

        System.out.println("Enter Product Quantity : ");
        int prodQty = scanner.nextInt();

        System.out.println("Processing Product Total Amount");

        double totalAmt = prodPrice * prodQty;
        System.out.println("TOTAL_AMT : " + totalAmt);
        try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}

		System.out.println("<=========== SUPERMARKET " + recordNumber + " DATA READING ENDS <===========");

		System.out.println("===========> SUPERMARKET " + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");

		//pw.println();
		String line = prodName + "," + prodId + "," + prodPrice + "," + prodQty + "," + totalAmt;
		pw.println(line);

		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		System.out.println();
		System.out.println("<=========== SUPERMARKET " + recordNumber + " DATA WRITING INTO CSV File ENDS <===========");
	}

}
