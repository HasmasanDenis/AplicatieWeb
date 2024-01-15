package com.example.shop.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepository  {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // Functia ce se ocupa cu adaugarea unui produs nou in database
    public void setProduct(Product product){
        String sql = "INSERT INTO `product` (`name`, `price`,`stock`, `short_desc`) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getStock(), product.getShortDesc());
    }
    // Functia ce se ocupa de primirea detaliilor produselor stocate in database
    public List<Product> getProducts(){
        String sql = "SELECT id, name, price, stock, short_desc FROM product";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
    }

}

