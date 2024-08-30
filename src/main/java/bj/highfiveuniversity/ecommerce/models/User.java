package bj.highfiveuniversity.ecommerce.models;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;
import lombok.NoArgsConstructor;
import java.util.List;

// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
// @RequiredArgsConstructor

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "user")
   private List<Order> orders;

   // s'execute quand on insère une donnée
    @PrePersist
protected void onCreate(){
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
}

@PreUpdate
protected void onUpdate(){
    updatedAt = LocalDateTime.now();
}
  
}
