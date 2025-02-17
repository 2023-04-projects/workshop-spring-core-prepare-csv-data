package com.khadri.spring.core.csv.prepare.data.movie.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;

import com.khadri.spring.core.csv.prepare.data.movie.constants.MovieCsvHeaders;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class MovieFileUtil {
	private static PrintWriter pw;
	private static File file;

	public static Tuple2<File, PrintWriter> movieCsvFilePrintWriter(ApplicationContext applicationContext) {
		System.out.println("===========> MOVIE CSV File Creation  STARTS ===========>");

		file = (File) applicationContext.getBean("movieFile");
		pw = (PrintWriter) applicationContext.getBean("printWriterMovie");
		try (PrintWriter printWriter = new PrintWriter(file)) {
			printWriter.println("Movie data goes here");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			boolean newFile = file.createNewFile();

			if (newFile) {
				System.out.println("File is new, writing header...");
				Arrays.stream(MovieCsvHeaders.values()).forEach(eachHeader -> {
					pw.print(eachHeader.name());
					pw.println(",");
				});
				pw.println();
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
		System.out.println("<=========== MOVIES CSV File Creation ENDS <===========");

		return Tuple.of(file, pw);
	}
}