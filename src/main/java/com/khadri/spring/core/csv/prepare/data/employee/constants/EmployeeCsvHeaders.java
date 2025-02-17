package com.khadri.spring.core.csv.prepare.data.employee.constants;

public enum EmployeeCsvHeaders {
	ID(1), NAME(2), DESIGINATION(3), SALARY(4);

	private int id;

	private EmployeeCsvHeaders(int id) {
		this.id = id;

	}

	public int getId() {
		return id;
	}
}
