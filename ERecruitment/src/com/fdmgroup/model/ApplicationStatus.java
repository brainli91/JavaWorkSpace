package com.fdmgroup.model;

public enum ApplicationStatus {

  PENDING("Pending"), ACCEPTED("Accepted"), REJECTED("Rejected");

  private String name;

  public static ApplicationStatus getByName(String s) {
    if (s == null) {
      return null;
    }
    return valueOf(s.toUpperCase());
  }

  ApplicationStatus(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
