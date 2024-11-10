package com.example.inventory;

import com.example.inventory.dao.InventoryRepository;
import com.example.inventory.model.Inventory;
import com.example.inventory.service.InventoryService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableRabbit
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}


	@Bean
	public CommandLineRunner initDatabase(InventoryRepository inventoryRepository) {
		return (a) -> {
			inventoryRepository.save(new Inventory(null, "iphone", 100));
			inventoryRepository.save(new Inventory(null, "test", 0));


		};
	}
}
