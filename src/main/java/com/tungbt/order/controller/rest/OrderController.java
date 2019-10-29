package com.tungbt.order.controller.rest;

import com.tungbt.order.dto.request.CreateOrderRequest;
import com.tungbt.order.dto.response.CreateOrderResponse;
import com.tungbt.order.factory.ResponseFactory;
import com.tungbt.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ResponseFactory responseFactory;

	@PostMapping("/api/v1/orders")
	public ResponseEntity createOrder(@RequestBody CreateOrderRequest request){
		return responseFactory.success(orderService.createOrder(request), CreateOrderResponse.class);
	}

}
