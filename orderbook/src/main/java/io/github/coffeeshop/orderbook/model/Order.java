package io.github.coffeeshop.orderbook.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Objects;

@Document(collection = "orders")
public class Order {

   @Id
   private String id;
   private String customer;
   private Collection<String> productIds;

   public Order() {
      // noOp
   }

   public Order(String id, String customer, Collection<String> products) {
      this.id = id;
      this.customer = customer;
      this.productIds = products;
   }

   public String getId() {
      return id;
   }

   public String getCustomer() {
      return customer;
   }

   public Collection<String> getProductIds() {
      return productIds;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Order order = (Order) o;
      return Objects.equals(id, order.id) &&
            Objects.equals(customer, order.customer);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, customer);
   }

   @Override
   public String toString() {
      return "Order{" +
            "id='" + id + '\'' +
            ", customer='" + customer + '\'' +
            ", productIds=" + productIds +
            '}';
   }
}
