package com.khadri.spring.core.csv.prepare.data.mobile.constants;

public enum MobileCsvHeaders {

	MOBILE_ID(1), MOBILE_NAME(2), MOBILE_PRICE(3);

	private int id;

	private MobileCsvHeaders(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
