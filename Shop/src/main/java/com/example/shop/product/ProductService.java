package com.example.shop.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
// Functia ce preia datele produselor prezente pe site
    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }
// Functia pentru crearea unui produs nou
    public void createProduct(Product product) {
            productRepository.setProduct(product);
    }

    // Additional methods for business logic
}
