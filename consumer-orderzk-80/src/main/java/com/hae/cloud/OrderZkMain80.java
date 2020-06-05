package com.hae.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 使用zookeeper做注册中心
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class OrderZkMain80 {
  public static void main(String[] args) {
    SpringApplication.run(OrderZkMain80.class, args);
  }
}
