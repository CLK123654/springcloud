package com.hae.cloud.controller;

import com.hae.cloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  OrderFeignService service;

  @GetMapping("/consumer/payment/hystrix")
  public String payMentTimeOut(){
    return  service.payMentTimeOut();
  }

  @GetMapping("/consumer/payment/hystrix/ex")
  public String payMentException() {
    return  service.payMentException();
  }

}
