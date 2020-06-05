package com.hae.cloud.service;

import com.hae.cloud.entities.Payment;

public interface PayMentService {
  public int insert(Payment payment);

  public Payment getPaymentByid(Long id);
}
