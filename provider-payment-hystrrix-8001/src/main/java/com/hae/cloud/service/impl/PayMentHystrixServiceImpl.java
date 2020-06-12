package com.hae.cloud.service.impl;

import com.hae.cloud.service.PayMentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class PayMentHystrixServiceImpl implements PayMentHystrixService {

  @HystrixCommand(fallbackMethod = "payMentTimeOutHandler",commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
  })
  @Override
  public String payMentTimeOut() {
    long DELAY_TIME = 5000;
    try {
      Thread.sleep(DELAY_TIME);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return Thread.currentThread().getName() + "成功调用，耗时：" + DELAY_TIME;
  }

  public String payMentTimeOutHandler() {
    return "服务器繁忙，请稍后再试";
  }

  @HystrixCommand(fallbackMethod = "payMentExceptionHandler")
  @Override
  public String payMentException() {
    int i = 10/0;
    return Thread.currentThread().getName() + "成功调用";
  }

  private String payMentExceptionHandler() {
    return "系统错误，请稍后再试";
  }

  //=====服务熔断
  @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
          @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
  })
  @Override
  public String paymentCircuitBreaker(int id)
  {
    if (id < 0)
    {
      throw new RuntimeException("******id 不能负数");
    }
   String serialNumber = UUID.randomUUID().toString();

    return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
  }

  private String paymentCircuitBreaker_fallback(@PathVariable("id") int id) {
    return "fallback--------id:" + id;
  }
}
