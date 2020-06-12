package com.hae.cloud.controller;

import com.hae.cloud.service.PayMentHystrixService;
import com.hae.common.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  Logger log = LoggerFactory.getLogger();

  @Autowired
  PayMentHystrixService service;

  @Value("${server.port}")
  private String PORT;

  @GetMapping("/payment/hystrix")
  public String payMentTimeOut() {
    return service.payMentTimeOut();
  }

  @GetMapping("/payment/hystrix/ex")
  public String payMentEx() {
    return service.payMentException();
  }

  @GetMapping("/payment/hystrix/{id}")
  public String paymentCircuitBreaker(@PathVariable("id") int id) {
    return service.paymentCircuitBreaker(id);
  }
}
