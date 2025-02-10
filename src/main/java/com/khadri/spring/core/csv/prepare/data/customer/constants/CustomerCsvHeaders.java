package com.khadri.spring.core.csv.prepare.data.customer.constants;

public enum CustomerCsvHeaders {
	CUST_ID(1), NAME(2), ADDRESS(3), PHONE_NUM(4);
	private int id;

	private CustomerCsvHeaders(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
