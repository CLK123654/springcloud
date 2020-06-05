package com.hae.cloud.controller;

import com.hae.cloud.service.ServiceWithFeigh;
import com.hae.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  ServiceWithFeigh service;

  @GetMapping("/consumer/paymentFeigh/{id}")
  public CommonResult getByIDFeign(@PathVariable Long id) {
    return service.getByIDFeign(id);
  }

  /**
   * 测试超时任务，feigh默认是1s内要能获取服务调用的结果，超过则报超时错误
   * 解决：在配置文件中可自行设置超时的等待事件
   * @return
   */
  @GetMapping("/consumer/payment/timeDelay")
  public String payMentTimeDelay() {
    return service.payMentTimeDelay();
  }
}
