package com.example.shop.cart;

import com.example.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CartRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
// Clasa ce se ocupa de adaugarea unui produs in cos in database-ul cosului
    public void addToCart(Cart cart) {
        String sql = "INSERT INTO `cart` (`product_id`, `user_id`) VALUES (?, ?);";
        jdbcTemplate.update(sql, cart.getProductId(), cart.getUserId());
    }
// Clasa ce se ocupa de primirea continutul cosului stocat in database
    public List<Cart> getCart(String userId) {
        String sql = "SELECT id, product_id, user_id FROM cart WHERE user_id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cart.class), userId);
    }
// Clasa ce se ocupa de stergerea cosului din datbase
    public void deleteCart(Cart cart) {
        String sql ="DELETE FROM `shop`.`cart` WHERE user_id = 2";
        jdbcTemplate.execute(sql);
    }
}