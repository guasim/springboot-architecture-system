package com.guasim.dev.ms.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guasim.dev.ms.product.dto.ProductRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/product")
public class ProductController {

	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest request) {

		return null;
	}

}
