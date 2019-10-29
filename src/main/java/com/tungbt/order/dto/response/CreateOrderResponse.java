package com.tungbt.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {
  private Integer id;
  private Integer customerId;
  private String orderName;
  private Integer value;
}
