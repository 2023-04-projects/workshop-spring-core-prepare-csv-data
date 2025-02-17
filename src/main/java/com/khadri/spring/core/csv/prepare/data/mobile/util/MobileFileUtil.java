package com.khadri.spring.core.csv.prepare.data.mobile.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;

import com.khadri.spring.core.csv.prepare.data.mobile.constants.MobileCsvHeaders;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class MobileFileUtil {

	private static PrintWriter printWriter;
	private static File mobileFile;

	public static Tuple2<File, PrintWriter> mobileCsvFilePrintWriter(ApplicationContext applicationContext) {
		System.out.println("===========> MOBILE CSV File Creation  STARTS ===========>");

		try {
			mobileFile = (File) applicationContext.getBean("mobileFile");
			printWriter = (PrintWriter) applicationContext.getBean("printWriterMobile");
			boolean isNewFile = mobileFile.createNewFile();
			if (isNewFile) {
				System.out.println("File is new, writing header...");
				Arrays.stream(MobileCsvHeaders.values()).forEach(eachHeader -> {
					printWriter.print(eachHeader.name());
					printWriter.print(",");
				});
				printWriter.println(",");
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

		System.out.println("File Name : " + mobileFile.getName() + " Created At : " + mobileFile.getPath());
		System.out.println("<=========== MOBILE CSV File Creation ENDS <===========");

		return Tuple.of(mobileFile, printWriter);
	}

}
