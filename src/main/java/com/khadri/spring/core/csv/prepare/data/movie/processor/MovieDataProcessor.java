package com.khadri.spring.core.csv.prepare.data.movie.processor;

import java.io.PrintWriter;
import java.util.Scanner;

public class MovieDataProcessor {
	private Scanner scanner;

	public MovieDataProcessor(Scanner scanner) {
		this.scanner = scanner;
	}

	public void process(PrintWriter pw, int recordNumber) {
		System.out.println("===========> MOVIE " + recordNumber + " DATA READING STARTS ===========>");
		System.out.println("Enter Movie No : ");
		int id = scanner.nextInt();
		System.out.println("Enter Movie Name : ");
		String name = scanner.next();
		System.out.println("Enter Movie_Making_Price : ");
		double movieBudget = scanner.nextInt();
		System.out.println("Enter Movie_songs_Making_Price : ");
		double songPrice = scanner.nextInt();

		System.out.println("Processing Movie TOTAL_Collection ");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		double totalCollection = movieBudget + songPrice;
		System.out.println(" : " + totalCollection);
		System.out.println("Processing Movie Avg Marks");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		double avg = totalCollection / 3;
		System.out.println(" : " + avg);
		System.out.println("Processing Movie Grade ");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		String rating = processGrade(avg);
		System.out.println(" : " + rating);
		System.out.println("<=========== Movie " + recordNumber + " DATA READING ENDS <===========");
		System.out.println("===========> Movie " + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");
		pw.println();// new empty row
		String line = id + "," + name + "," + movieBudget + "," + songPrice + "," + totalCollection + "," + avg + ","
				+ rating;
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
		System.out.println("<=========== Movie " + recordNumber + " DATA WRITING INTO CSV File ENDS <===========");
	}

	private String processGrade(double avg) {
		if (avg >= 9000000 && avg <= 1000000000.00) {
			return "BlockBuster";
		} else if (avg >= 7500000 && avg <= 8900000) {
			return "SuperHit";
		} else if (avg >= 6000000 && avg <= 7400000) {
			return "Hit";
		} else if (avg >= 4500000 && avg <= 5900000) {
			return "Average";
		} else if (avg >= 3500000 && avg <= 4400000) {
			return "BelowAverage";
		} else {
			return "Flap....!";
		}
	}
}