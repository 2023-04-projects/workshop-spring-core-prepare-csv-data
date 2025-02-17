package com.khadri.spring.core.csv.prepare.data.supermarket.constant;

public enum SuperMarkeCsvHeader {

	 PROD_ID(1), PROD_NAME(2), PROD_PRICE(3), PROD_QTY(4), TOTAL_AMOUNT(5);

	private int id;

	private SuperMarkeCsvHeader(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}