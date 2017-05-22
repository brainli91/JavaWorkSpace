package com.fdmgroup.entity;

public enum AppointmentStatus {
	COMPLETE("Complete"), CONFIRMED("Confirmed"), NOTCONFIRMED("Not Confirmed"), RESCHEDULED("Rescheduled"), CANCELLED(
			"Cancelled"), NOSHOW("No Show");

	private String name;

	public static AppointmentStatus getByName(String s) {
		if (s == null) {
			return null;
		}
		return valueOf(s.toUpperCase());
	}

	AppointmentStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
