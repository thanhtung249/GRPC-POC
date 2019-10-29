package com.tungbt.order.service.impl;

import com.tungbt.order.grpc.CreateOrderGrpcRequest;
import com.tungbt.order.grpc.CreateOrderGrpcResponse;
import com.tungbt.order.grpc.OrderServiceGrpc;
import com.tungbt.order.grpc.OrderServiceGrpc.OrderServiceBlockingStub;
import com.tungbt.order.service.GRpcClientService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GRpcClientServiceImpl implements GRpcClientService {

  @Override
  public CreateOrderGrpcResponse createOrder(String host, Integer port, CreateOrderGrpcRequest request){
    ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext().build();

    OrderServiceBlockingStub client = OrderServiceGrpc.newBlockingStub(channel);

    CreateOrderGrpcResponse response = client.checkAndReduceBalance(request);
    return  response;
  }
}
