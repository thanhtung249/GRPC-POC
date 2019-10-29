package com.tungbt.order.mapper;

import com.tungbt.order.dto.request.CreateOrderRequest;
import com.tungbt.order.dto.response.CreateOrderResponse;
import com.tungbt.order.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  OrderEntity createOrderRequestToOrderEntity(CreateOrderRequest request);
  CreateOrderResponse orderEntityToCreateOrderResponse(OrderEntity entity);

}
