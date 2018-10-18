package io.github.coffeeshop.catalogue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "products")
public class Product {
   @Id
   private String id;
   private String name;
   private String description;
   private String imageUrl;
   private String code;

   public Product() {
      // noOP
   }

   public Product(String name, String description, String imageUrl, String code) {
      this.name = name;
      this.description = description;
      this.imageUrl = imageUrl;
      this.code = code;
   }

   public String getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public String getCode() {
      return code;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Product product = (Product) o;
      return Objects.equals(id, product.id) &&
            Objects.equals(name, product.name) &&
            Objects.equals(description, product.description) &&
            Objects.equals(imageUrl, product.imageUrl) &&
            Objects.equals(code, product.code);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, description, imageUrl, code);
   }

   @Override
   public String toString() {
      return "Product{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", code='" + code + '\'' +
            '}';
   }
}
