package com.guasim.dev.ms.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guasim.dev.ms.order.dto.OrderRequest;
import com.guasim.dev.ms.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	@Autowired
	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest request) {
		return orderService.placeOrder(request);
	}

}
