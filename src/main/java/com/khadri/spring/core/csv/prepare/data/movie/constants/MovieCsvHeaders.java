package com.khadri.spring.core.csv.prepare.data.movie.constants;

public enum MovieCsvHeaders {
	ID(1), Movie_NAME(2), Movie_Making_Price(3), Movie_songs_Making_Price(4), TOTAL_Collection(5), AVG(6), GRADE(8);

	private int id;

	private MovieCsvHeaders(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}