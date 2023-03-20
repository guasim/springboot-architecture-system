package com.guasim.dev.ms.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guasim.dev.ms.product.dto.ProductRequest;
import com.guasim.dev.ms.product.dto.ProductResponse;
import com.guasim.dev.ms.product.model.Product;
import com.guasim.dev.ms.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

	@Autowired
	private final ProductRepository repository;

	public ResponseEntity<String> addProduct(ProductRequest request) {

		Product product = Product.builder().name(request.getName()).decription(request.getDescription())
				.price(request.getPrice()).build();
		repository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product.toString());
	}

	public ResponseEntity<List<ProductResponse>> getProductList() {
		List<Product> productsFound = repository.findAll();

		List<ProductResponse> productList = productsFound.stream().map(this::mapToProductResponse).toList();

		return ResponseEntity.status(HttpStatus.FOUND).body(productList);
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDecription()).price(product.getPrice()).build();
	}
}