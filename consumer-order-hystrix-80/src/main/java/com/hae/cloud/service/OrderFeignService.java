package com.hae.cloud.service;

import com.hae.cloud.service.fallback.OrderFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = OrderFeignServiceFallBack.class)
@Service
public interface OrderFeignService {
  @GetMapping("/payment/hystrix")
  public String payMentTimeOut();

  @GetMapping("/payment/hystrix/ex")
  public String payMentException();
}
