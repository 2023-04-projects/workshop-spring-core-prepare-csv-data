package com.khadri.spring.core.csv.prepare.data.supermarket.constant;

public enum SuperMarkeCsvtHeader {

	PROD_NAME(1), PROD_ID(2), PROD_PRICE(3), PROD_QTY(4), TOTAL_AMOUNT(5);

	private int id;

	private SuperMarkeCsvtHeader(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
