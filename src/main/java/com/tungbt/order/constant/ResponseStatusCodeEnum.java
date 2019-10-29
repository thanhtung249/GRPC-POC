package com.tungbt.order.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatusCodeEnum {
  SUCCESS("0", "Success");

  private String code;
  private String message;
}
