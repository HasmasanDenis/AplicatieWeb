package com.example.shop.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getCart(String userId) {
        List<Cart> cart = cartRepository.getCart(userId);
        return cart;
    }

    public void addToCart(Cart cart) {
        cartRepository.addToCart(cart);
    }

    public void deleteCart(Cart cart){
        cartRepository.deleteCart(cart);
    }


}
