package io.github.coffeeshop.catalogue.web;

import io.github.coffeeshop.catalogue.model.Product;
import io.github.coffeeshop.catalogue.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

   private final ProductRepository repository;

   public ProductController(ProductRepository repository) {
      this.repository = repository;
   }

   @GetMapping("/products")
   Flux<Product> getProducts() {
      return repository.findAll();
   }

   @GetMapping("/products/{code}")
   Mono<Product> getProductByCode(@PathVariable String code) {
      return repository.findFirstByCode(code);
   }
}
