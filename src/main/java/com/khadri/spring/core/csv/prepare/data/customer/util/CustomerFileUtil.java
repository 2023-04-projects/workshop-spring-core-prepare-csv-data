package com.khadri.spring.core.csv.prepare.data.customer.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.khadri.spring.core.csv.prepare.data.customer.constants.CustomerCsvHeaders;

import io.vavr.Tuple;
import io.vavr.Tuple2;

@Component
public class CustomerFileUtil {
	public static PrintWriter printWriter;
	public static File file;

	public static Tuple2<File, PrintWriter> customerCsvFilePrintWriter(ApplicationContext applicationContext ) {
		System.out.println("===========> CUSTOMER CSV File Creation  STARTS ===========>");

		try {

			file = applicationContext.getBean(File.class);
			printWriter = applicationContext.getBean(PrintWriter.class);
			System.out.println(file);

			boolean isNewFile = file.createNewFile();

			if (isNewFile) {
				System.out.println("File is new, writing header...");
				Arrays.stream(CustomerCsvHeaders.values()).forEach(eachHeader -> {
					printWriter.print(eachHeader.name());
					printWriter.print(",");
				});
				printWriter.println();
			} else {
				System.out.println("File already exists, skipping header...");
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
		System.out.println("<=========== CUSTOMER CSV File Creation ENDS <===========");

		System.out.println("===========> CUSTOMER HEADER ROW WRITING INTO CSV File STARTS ===========>");

		System.out.println("<=========== CUSTOMER HEADER ROW WRITING INTO CSV File ENDS <===========");

		return Tuple.of(file, printWriter);
	}

}
