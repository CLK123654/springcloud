package com.hae.cloud.service.fallback;

import com.hae.cloud.service.OrderFeignService;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignServiceFallBack implements OrderFeignService {
  @Override
  public String payMentTimeOut() {
    return "连接服务超时，请稍后再试";
  }

  @Override
  public String payMentException() {
    return "服务器出错，请稍后再试";
  }
}
