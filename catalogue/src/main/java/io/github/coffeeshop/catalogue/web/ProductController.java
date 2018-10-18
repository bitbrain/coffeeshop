package io.github.coffeeshop.catalogue.web;

import io.github.coffeeshop.catalogue.dto.ProductDTO;
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
   Flux<ProductDTO> getProducts() {
      return repository.findAll()
            .map(this::convertToDTO);
   }

   @GetMapping("/products/{code}")
   Mono<ProductDTO> getProductByCode(@PathVariable String code) {
      return repository.findFirstByCode(code)
            .map(this::convertToDTO);
   }

   private ProductDTO convertToDTO(Product product) {
      return new ProductDTO(
            product.getName(),
            product.getDescription(),
            product.getImageUrl(),
            product.getCode()
      );
   }
}
