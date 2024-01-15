package com.example.shop.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;
// Request catre front-end de adaugarea unui produs in cosul de cumparaturi
    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Cart cart) {
        if (cart != null) {
            cartService.addToCart(cart);
        }
        return null;
    }
// Request catre front-end de a sterge continutul cosului de cumparaturi
    @PostMapping("/deleteCart")
    public ResponseEntity<?> deleteCart(@RequestBody Cart cart) {
        cartService.deleteCart(cart);
        return null;
    }


    // additional endpoints
}
