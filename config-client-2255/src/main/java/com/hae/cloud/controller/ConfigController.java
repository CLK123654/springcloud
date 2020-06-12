package com.hae.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

  /**
   * version从config-center中获取值
   */
  @Value("${version}")
  private String VERSION;

  @GetMapping("/version")
  public String getVersion() {
    return VERSION;
  }
}
