package com.example.shop.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController

@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
// Request catre front-end de a primi informatiile produselor prezente in site
    @PostMapping("/products")
    public List<Product> getAllProducts() {
        //Response catre front-end continand produsele prezente pe site
        return productService.getAllProducts();
    }
    // Request catre front-end pentru adaugarea unui produs in database
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        if (product != null ){
            productService.createProduct(product);
        } 
        return null;
    } 

    // additional endpoints
}
