package com.example.javaproject.service;

import com.example.javaproject.Entity.Product;
import com.example.javaproject.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProduct() throws Exception {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Product getProductById(Long id) throws Exception {
        try {
            return productRepository.findAllById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = false)
    public Product createProduct(Product product) throws Exception {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw e;
        }
    }


    @Transactional(readOnly = false)
    public Product updateProductById(Product product) throws Exception {
        Product productUpdate;
        try {
            productUpdate = productRepository.findAllById(product.getId());
            if(!Objects.isNull(productUpdate)){
                productUpdate.setId(product.getId());
                productUpdate.setName(product.getName());
                productUpdate.setMota(product.getMota());
                productUpdate.setStatus(product.getStatus());
                productUpdate.setPrice(product.getPrice());
                productRepository.saveAndFlush(productUpdate);
            }
        } catch (Exception e) {
            throw e;
        }
        return productUpdate;
    }

    @Transactional(readOnly = false)
    public String deleteProductById(Long id) throws Exception {
        String result = "";
        try {
            productRepository.deleteById(id);
            result = "Delete product success";
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
