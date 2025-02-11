package com.khadri.spring.core.csv.prepare.data.employee.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;

import com.khadri.spring.core.csv.prepare.data.employee.constants.EmployeeCsvHeaders;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class EmployeeFileUtil {
	private static PrintWriter pw;
	private static File employeeFile;

	public static Tuple2<File, PrintWriter> employeeCsvFilePrintWriter(ApplicationContext applicationContext) {
		System.out.println("===========> Employee CSV File Creation  STARTS ===========>");
		try {
			employeeFile =(File) applicationContext.getBean("employeeFile");
			pw = (PrintWriter)applicationContext.getBean("pw");
			boolean isNewFile = employeeFile.createNewFile();

			if (isNewFile) {
				System.out.println("File is new, writing header...");
				Arrays.stream(EmployeeCsvHeaders.values()).forEach(eachHeader -> {
					pw.print(eachHeader.name());
					pw.print(",");
				});
				pw.println(",");
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
		System.out.println("File Name : " + employeeFile.getName() + " Created At : " + employeeFile.getPath());

		System.out.println("<=========== EMPLOYEE CSV File Creation ENDS <===========");
		
		return Tuple.of(employeeFile, pw);
	}
}