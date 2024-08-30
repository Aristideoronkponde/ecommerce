package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false, unique = true)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false)
  private Double price;

  @Column(name = "stock_quantity", nullable = false)
  private Integer stockQty;
  
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
