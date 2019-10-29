package com.tungbt.order.service;

import com.tungbt.order.dto.request.CreateOrderRequest;
import com.tungbt.order.dto.response.CreateOrderResponse;

public interface OrderService {
  CreateOrderResponse createOrder(CreateOrderRequest orderRequest);
}
