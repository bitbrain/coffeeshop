package io.github.coffeeshop.catalogue.repository;

import io.github.coffeeshop.catalogue.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

   Mono<Product> findFirstByCode(String code);
}
