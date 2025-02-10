package com.khadri.spring.core.csv.prepare.data.supermarket.util;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khadri.spring.core.csv.prepare.data.supermarket.constant.SuperMarkeCsvtHeader;

public class SuperMarketFileUtil {

	private static PrintWriter pw;
	private static File file;

	public static Tuple2<File, PrintWriter> superMarketCsvFilePrintWriter(AnnotationConfigApplicationContext applicationContext) {
		System.out.println("===========>  SUPERMARKET CSV File Creation  STARTS ===========>");

		try {
			//file = new File("src/main/resources/supermarket.csv");
			 file = applicationContext.getBean(File.class);
			boolean isNewFile = file.createNewFile();
			//pw = new PrintWriter(new FileWriter(file, true));
			 pw = applicationContext.getBean(PrintWriter.class);

			if (isNewFile) {
				System.out.println("File is new, Writing header ...! ");
				Arrays.stream(SuperMarkeCsvtHeader.values()).forEach(eachHeader -> {
					pw.print(eachHeader.name());
					pw.print(",");
				});
				pw.println();
			} else {
				System.out.println("File already exists, skipping Header");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Process of File creation In Progress");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}

		System.out.println("File Name : " + file.getName() + " Created At : " + file.getPath());
		System.out.println("<=========== SUPERMARKET CSV File Creation ENDS <===========");

		System.out.println("===========> SUPERMARKET HEADER ROW WRITING INTO CSV File STARTS ===========>");

		System.out.println("Process of Writing Headers into : " + file.getName());

		System.out.println(" <=========== SUPERMARKET HEADER ROW WRITING INTO CSV FILE ENDS <===========");
		return Tuple.of(file, pw);
	}
}
