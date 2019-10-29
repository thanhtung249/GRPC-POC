package com.tungbt.order.service.impl;

import com.tungbt.order.config.ServiceConfiguration;
import com.tungbt.order.dto.request.CreateOrderRequest;
import com.tungbt.order.dto.response.CreateOrderResponse;
import com.tungbt.order.entity.OrderEntity;
import com.tungbt.order.grpc.CreateOrderGrpcRequest;
import com.tungbt.order.grpc.CreateOrderGrpcResponse;
import com.tungbt.order.mapper.OrderMapper;
import com.tungbt.order.repository.OrderRepository;
import com.tungbt.order.service.GRpcClientService;
import com.tungbt.order.service.OrderService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private GRpcClientService gRpcClientService;

  @Autowired
  private ServiceConfiguration serviceConfiguration;

  @Override
  public CreateOrderResponse createOrder(CreateOrderRequest orderRequest){

    //Prepare CreateOrder GRPC Request
    CreateOrderGrpcRequest request = CreateOrderGrpcRequest.newBuilder()
                                      .setCustomerId(orderRequest.getCustomerId())
                                      .setValue(orderRequest.getValue())
                                      .build();
    //Calling to grpc server
    CreateOrderGrpcResponse grpcResponse = gRpcClientService.createOrder(
                                                  serviceConfiguration.getCustomerServiceHost(),
                                                  serviceConfiguration.getCustomerServicePort(),
                                                  request);
    // Check result and convert to Entity before save to DB
    if (grpcResponse != null && "0".equalsIgnoreCase(grpcResponse.getCode())){
      Random random = new Random();
      OrderEntity entity = new OrderEntity();
      entity.setId(random.nextInt(Integer.MAX_VALUE));
      entity.setCustomerId(orderRequest.getCustomerId());
      entity.setOrderName(orderRequest.getOrderName());
      entity.setValue(orderRequest.getValue());
      CreateOrderResponse response = OrderMapper.INSTANCE.orderEntityToCreateOrderResponse(orderRepository.save(entity));
      return response;

    } else{
      return null;
    }

  }
}
