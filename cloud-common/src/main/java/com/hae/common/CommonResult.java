package com.hae.common;

public class CommonResult<T> {
  private String error;
  private String message;
  private T data;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setErr(ErrorResults err) {
    setError(err.name());
    setMessage(err.getMessage());
  }
}
