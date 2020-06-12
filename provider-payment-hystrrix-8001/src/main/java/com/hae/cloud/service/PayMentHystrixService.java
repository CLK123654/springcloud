package com.hae.cloud.service;


public interface PayMentHystrixService {
  public String payMentTimeOut();

  public String payMentException();

  public String paymentCircuitBreaker(int id);
}
