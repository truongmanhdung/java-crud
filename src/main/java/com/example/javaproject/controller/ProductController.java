package com.example.javaproject.controller;

import com.example.javaproject.Entity.Product;
import com.example.javaproject.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * GET /products : get all products
     *
     * @return the ResponseEntity with status 200 (OK) and with body all products
     */
    @GetMapping("/products")
    public  List<Product> getAllProduct() throws Exception {
        List products = productService.getAllProduct();
        return products;
    }
    /**
     * GET /product/{id} : get product by id
     *
     * @return the ResponseEntity with status 200 (OK) and with body product
     */
    @GetMapping("/product/{id}")
    public  Product getProductById(@PathVariable Long id) throws Exception {
        Product product = productService.getProductById(id);
        return product;
    }

    /**
     * POST /product : create product
     *
     * @return the ResponseEntity with status 200 (OK) and with create product
     */
    @PostMapping("/product")
    public  Product createProduct(@RequestBody Product product) throws Exception {
        return productService.createProduct(product);
    }

    /**
     * PUT /product : update product
     *
     * @return the ResponseEntity with status 200 (OK) and with create product
     */
    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product) throws Exception {
        return productService.updateProductById(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProductById(@PathVariable String id) throws Exception {
        return productService.deleteProductById(Long.valueOf(id));
    }


}
