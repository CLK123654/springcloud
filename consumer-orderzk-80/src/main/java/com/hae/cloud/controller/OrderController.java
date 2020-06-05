package com.hae.cloud.controller;

import com.hae.cloud.entities.Payment;
import com.hae.common.CommonResult;
import com.hae.common.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 测试断掉eureka服务器时，client仍然能调用服务  原因：EurekaClient会缓存注册表信息
 */
@RestController
public class OrderController {
  private static final String PAYMENT_URL = "http://cloud-payment-service";

  private Logger log = LoggerFactory.getLogger();

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  DiscoveryClient discoveryClient;

  @GetMapping("/consumer/payment")
  public CommonResult insert(Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, CommonResult.class);
  }

  @GetMapping("/consumer/payment/{id}")
  public CommonResult getById(@PathVariable Long id) {
    return restTemplate.getForObject(PAYMENT_URL + "/payment/"+id, CommonResult.class);
  }

  @GetMapping("testDiscovery")
  public Object discovery() {
    List<String> services = discoveryClient.getServices();
    for (String server : services) {
      List<ServiceInstance> instances = discoveryClient.getInstances(server);
      for (ServiceInstance instance : instances) {
        log.info(instance.getHost() + "--" + instance.getInstanceId() + "--" + instance.getUri() + "--" + instance.getPort());
      }
    }
    return services;
  }
}
