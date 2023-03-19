package com.guasim.dev.ms.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guasim.dev.ms.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
