package com.example.javaproject;

import com.example.javaproject.Entity.Product;
import com.example.javaproject.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class JavaProjectApplication {

    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaProjectApplication.class, args);
    }

//    @PostConstruct
//    void createData(){
//        for (int i = 6; i< 20; i++){
//            Product product = new Product();
//            product.setName("dung test" + i);
//            product.setStatus(0);
//            product.setPrice(12);
//            product.setDesc("test desc" + i);
//            productRepository.save(product);
//        }
//    }


//    @PostConstruct
//    void getData() {
//        List<Product> productList = productRepository.findAll();
//
//        for (Product product : productList
//        ) {
//            System.out.println(product.toString());
//        }
//
//    }

}
