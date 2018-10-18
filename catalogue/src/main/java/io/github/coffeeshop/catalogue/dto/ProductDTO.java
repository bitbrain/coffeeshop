package io.github.coffeeshop.catalogue.dto;

public class ProductDTO {

   private String name;
   private String description;
   private String imageUrl;
   private String code;

   public ProductDTO() {

   }

   public ProductDTO(String name, String description, String imageUrl, String code) {
      this.name = name;
      this.description = description;
      this.imageUrl = imageUrl;
      this.code = code;
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
}
