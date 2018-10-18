package io.github.coffeeshop.orderbook.repository;

import io.github.coffeeshop.orderbook.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

}
