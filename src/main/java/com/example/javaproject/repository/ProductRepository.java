package com.example.javaproject.repository;

import com.example.javaproject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findAllById(Long id);

    @Query(value = "select p from Product p where p.name LIKE %:name% and p.price = :price")
    List<Product> findByNameAndPrice(String name, int price);
}
