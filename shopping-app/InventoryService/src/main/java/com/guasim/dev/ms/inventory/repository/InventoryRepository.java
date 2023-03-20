package com.guasim.dev.ms.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guasim.dev.ms.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
