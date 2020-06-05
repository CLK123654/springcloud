package com.hae.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 使用zookeeper做服务注册中心，zookeeper server在linux启动
 * @author hhb
 */

@EnableCaching
@SpringBootApplication
public class PaymentMain8004 {
  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8004.class, args);
  }
}
