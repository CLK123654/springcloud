package com.hae.cloud.service;

import com.hae.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Component能成功将接口注入到容器是因为springboot识别了该接口作为feign的服务
 * 需要添加@FeignClient  以及在启动类中开启feign
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface ServiceWithFeigh {
  @GetMapping("/payment/{id}")
  public CommonResult getByIDFeign(@PathVariable("id") Long id);

  @GetMapping("/payment/timeDelay")
  public String payMentTimeDelay();
}
