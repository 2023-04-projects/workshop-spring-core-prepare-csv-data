package com.khadri.spring.core.csv.prepare.data.driver;

public enum DriverTypes {
	STUDENT(1, "student"), EMPLOYEE(2, "employee"), CUSTOMER(3, "customer"), SUPER_MARKET(4, "supermarket"),
	MOVIE(5, "movie"), MOBILE(6, "mobile");

	private Integer id;
	private String name;

	DriverTypes(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
