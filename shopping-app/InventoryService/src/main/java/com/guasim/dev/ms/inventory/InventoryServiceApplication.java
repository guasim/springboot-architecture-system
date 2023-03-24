package com.guasim.dev.ms.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.guasim.dev.ms.inventory.model.Inventory;
import com.guasim.dev.ms.inventory.repository.InventoryRepository;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository repository) {

		return args -> {
			Inventory inv1 = new Inventory();
			inv1.setSkuCode("iphone_13");
			inv1.setQuantity(5);
			repository.save(inv1);

			Inventory inv2 = new Inventory();
			inv2.setSkuCode("iphone_11");
			inv2.setQuantity(0);
			repository.save(inv2);

			Inventory inv3 = new Inventory();
			inv3.setSkuCode("igalaxy_fold_3");
			inv3.setQuantity(2);
			repository.save(inv3);
		};
	}
}
