package io.github.coffeeshop.orderbook.dto;

import java.util.Collection;
import java.util.Objects;

public class OrderDTO {

   private String id;
   private String customer;
   private Collection<String> productIds;

   public OrderDTO() {
      // noOp
   }

   public OrderDTO(String id, String customer, Collection<String> products) {
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
      OrderDTO orderDTO = (OrderDTO) o;
      return Objects.equals(id, orderDTO.id) &&
            Objects.equals(customer, orderDTO.customer);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, customer);
   }

   @Override
   public String toString() {
      return "OrderDTO{" +
            "id='" + id + '\'' +
            ", customer='" + customer + '\'' +
            ", productIds=" + productIds +
            '}';
   }
}
