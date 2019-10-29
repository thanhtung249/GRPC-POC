package com.tungbt.customer.service;

import com.tungbt.customer.constant.GrpcResponseStatusCodeEnum;

public interface CustomerService {
  GrpcResponseStatusCodeEnum checkAndReduceBalance(Integer customerId, Integer orderValue);
}
