package com.example.javaproject.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "product")
@Getter
@Setter
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String mota;
    @Column
    private int price;
    @Column
    private int status;

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_date")
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    private void insert(){
        createdBy = "dungtm";
    }
    @PreUpdate
    private void update(){
        createdBy = "dungtm123";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
