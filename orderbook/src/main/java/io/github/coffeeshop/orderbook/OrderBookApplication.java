package io.github.coffeeshop.orderbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class OrderBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderBookApplication.class, args);
	}
}
