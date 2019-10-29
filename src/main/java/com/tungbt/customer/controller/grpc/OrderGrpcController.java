package com.tungbt.customer.controller.grpc;


import com.tungbt.customer.constant.GrpcResponseStatusCodeEnum;
import com.tungbt.customer.service.CustomerService;
import com.tungbt.order.grpc.CreateOrderGrpcRequest;
import com.tungbt.order.grpc.CreateOrderGrpcResponse;
import com.tungbt.order.grpc.OrderServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class OrderGrpcController extends OrderServiceGrpc.OrderServiceImplBase {

  @Autowired
  private CustomerService customerService;

  @Override
  public void checkAndReduceBalance(CreateOrderGrpcRequest request, StreamObserver<CreateOrderGrpcResponse> responseStreamObserver){

    GrpcResponseStatusCodeEnum result = customerService.checkAndReduceBalance(request.getCustomerId(), request.getValue());
    CreateOrderGrpcResponse response = CreateOrderGrpcResponse.newBuilder()
                                          .setCode(result.getCode()).setDescription(result.getMessage()).build();

    responseStreamObserver.onNext(response);
    responseStreamObserver.onCompleted();
  }

}
