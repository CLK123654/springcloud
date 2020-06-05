package com.hae.cloud.controller;

import com.hae.cloud.entities.Payment;
import com.hae.cloud.service.PayMentService;
import com.hae.common.CommonResult;
import com.hae.common.ErrorResults;
import com.hae.common.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  Logger log = LoggerFactory.getLogger();

  @Autowired
  PayMentService payMentService;

  @Value("${server.port}")
  private String PORT;

  @PostMapping("/payment")
  public CommonResult insert(@RequestBody Payment payment) {
    int ret = payMentService.insert(payment);
    CommonResult commonResult = new CommonResult();
    log.info("插入数据结果:" + ret +  ":" + PORT);
    if (ret > 0) {
      commonResult.setData(ret);
    } else {
      commonResult.setErr(ErrorResults.INSERT_FAILD);
    }
    return  commonResult;
  }

  @GetMapping("/payment/{id}")
  public CommonResult getByID(@PathVariable Long id) {
    Payment payment = payMentService.getPaymentByid(id);
    CommonResult commonResult = new CommonResult();
    log.info("查询数据:" + PORT);
    if (payment != null) {
      commonResult.setData(payment);
    } else {
      log.error("无记录" + id);
      commonResult.setErr(ErrorResults.SELECT_FAILD);
    }
    return commonResult;
  }
}
