package com.fdmgroup.model;

public enum JobStatus {

  ACTIVE("Active"), COMPLETED("Completed"), CANCELLED("Cancelled");

  private String name;

  public static JobStatus getByName(String s) {
    if (s == null) {
      return null;
    }
    return valueOf(s.toUpperCase());
  }

  JobStatus(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
