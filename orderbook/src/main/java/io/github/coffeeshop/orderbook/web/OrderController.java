package io.github.coffeeshop.orderbook.web;

import io.github.coffeeshop.orderbook.dto.OrderDTO;
import io.github.coffeeshop.orderbook.model.Order;
import io.github.coffeeshop.orderbook.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class OrderController {

   private final OrderRepository repository;

   public OrderController(OrderRepository repository) {
      this.repository = repository;
   }

   @GetMapping("/orders")
   public Flux<OrderDTO> getOrders() {
      return repository.findAll()
            .map(this::convertToDTO);
   }

   @GetMapping("/orders/{id}")
   public Mono<OrderDTO> getOrderById(@PathVariable String id) {
      return repository.findById(id)
            .map(this::convertToDTO);
   }

   @PostMapping("/order")
   public Mono<OrderDTO> submitOrder(@RequestBody OrderDTO order) {
      return repository.insert(convertToModel(order))
            .map(this::convertToDTO);
   }

   private OrderDTO convertToDTO(Order order) {
      return new OrderDTO(
            order.getId(),
            order.getCustomer(),
            order.getProductIds()
      );
   }

   private Order convertToModel(OrderDTO order) {
      return new Order(
            order.getId(),
            order.getCustomer(),
            order.getProductIds()
      );
   }
}
