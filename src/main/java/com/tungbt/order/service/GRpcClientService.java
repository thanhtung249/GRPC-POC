package com.tungbt.order.service;

import com.tungbt.order.grpc.CreateOrderGrpcRequest;
import com.tungbt.order.grpc.CreateOrderGrpcResponse;

public interface GRpcClientService {
   CreateOrderGrpcResponse createOrder(String host, Integer port, CreateOrderGrpcRequest request);
}
