package com.hae.cloud.service.impl;

import com.hae.cloud.dao.PaymentDao;
import com.hae.cloud.entities.Payment;
import com.hae.cloud.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PayMentServiceImpl implements PayMentService {

  @Autowired
  PaymentDao paymentDao;

  @Override
  public int insert(Payment payment) {
    return paymentDao.insert(payment);
  }

  @Cacheable(cacheNames = "payment")
  @Override
  public Payment getPaymentByid(Long id) {
    return paymentDao.getPaymentByid(id);
  }
}
