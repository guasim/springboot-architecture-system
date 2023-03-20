package com.guasim.dev.ms.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guasim.dev.ms.product.dto.ProductRequest;
import com.guasim.dev.ms.product.dto.ProductResponse;
import com.guasim.dev.ms.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private final ProductService service;

	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest request) {
		return service.addProduct(request);
	}

	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		return service.getProductList();
	}
}