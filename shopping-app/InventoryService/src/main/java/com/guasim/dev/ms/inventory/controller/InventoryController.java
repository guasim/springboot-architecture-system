package com.guasim.dev.ms.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guasim.dev.ms.inventory.dto.InventoryResponse;
import com.guasim.dev.ms.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	@Autowired
	private final InventoryService service;

	@GetMapping("/{sku-code}")
	public List<InventoryResponse> inStock(@RequestParam List<String> skuCodes) {
		return service.isInStock(skuCodes);
	}

}
