package com.fdmgroup.model;

public enum InterviewType {

  PHONE("Phone"), IN_PERSON("In Person"), ASSESSMENT("Assessment"), ONLINE("Online");

  private String name;

  public static InterviewType getByName(String s) {
    if (s == null) {
      return null;
    }
    return valueOf(s.toUpperCase());
  }

  InterviewType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
