package com.hae.common;


public enum ErrorResults {

  INSERT_FAILD("insert failed"),

  SELECT_FAILD("select failed");

  private String message;
  private ErrorResults(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
