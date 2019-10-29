package com.tungbt.customer.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GrpcResponseStatusCodeEnum {
  SUCCESS("0", "Success"),
  CUSTOMER_NOT_FOUND("1", "Customer not found"),
  NOT_ENOUGH_BALANCE("2", "Not enough balance"),
  UNKNOWN_REASON("500", "Unknwon reason");


  private String code;
  private String message;
}
