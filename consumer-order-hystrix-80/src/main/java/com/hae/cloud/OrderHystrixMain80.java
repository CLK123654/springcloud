package com.hae.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 使用feign自带的服务降级功能
 */
@EnableFeignClients
@SpringBootApplication
public class OrderHystrixMain80 {
  public static void main(String[] args) {
    SpringApplication.run(OrderHystrixMain80.class, args);
  }
}
