package com.guasim.dev.ms.order.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guasim.dev.ms.order.dto.OrderLineItemsDto;
import com.guasim.dev.ms.order.dto.OrderRequest;
import com.guasim.dev.ms.order.model.Order;
import com.guasim.dev.ms.order.model.OrderLineItems;
import com.guasim.dev.ms.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

	@Autowired
	private final OrderRepository repository;

	public ResponseEntity<String> placeOrder(OrderRequest request) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems = request.getOrderLineItemsDtoList().stream().map(this::mapToDto).toList();

		order.setItems(orderLineItems);

		repository.save(order);

		return ResponseEntity.status(HttpStatus.CREATED).body("The order has been placed successfully!");
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}

}
