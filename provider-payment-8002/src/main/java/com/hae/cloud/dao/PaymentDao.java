package com.hae.cloud.dao;

import com.hae.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
  
  public int insert(Payment payment);

  public Payment getPaymentByid(Long id);
}
