package com.fdmgroup.model;

public enum InterviewResult {

  PASS("Pass"), FAIL("Fail"), PENDING("Pending"), CANCELLED("Cancelled");

  private String name;

  public static InterviewResult getByName(String s) {
    if (s == null) {
      return null;
    }
    return valueOf(s.toUpperCase());
  }

  private InterviewResult(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
