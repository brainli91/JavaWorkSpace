package com.fdmgroup.entity;

public enum TransactionType {
	DESPOSITE("Deposite"), WITHDRAW("Withdraw"), CHARGE("Charge");

	private String name;

	TransactionType(String name) {
		this.name = name;
	}

	public static TransactionType getByName(String s) {
		if (s == null) {
			return null;
		}
		return valueOf(s.toUpperCase());
	}

	public String getName() {
		return name;
	}

}
