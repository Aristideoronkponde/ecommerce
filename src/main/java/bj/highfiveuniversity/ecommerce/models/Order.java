package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "oders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    //TODO:ajouter la clé secondaire user_id
    @Column(nullable = false)
    private Double totalamount;

    @Column(nullable = false)
    private String status;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt; 
}
