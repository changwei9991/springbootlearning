package com.example.service;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductsService productsService;

    public Long addToCart(Long productId, Long userId){
        Product product = productsService.getProductById(productId);
        if(product == null){
            return null;
        }
        Cart newCart = new Cart();
        newCart.setPrice(product.getPrice());
        newCart.setProduct(product);
        newCart.setUserId(userId);

        Cart entity = cartRepository.save(newCart);
        return entity.getCartId();
    }

    public String removeFromCart(Long userId){
        cartRepository.deleteByUserId(userId);
        return "success";
    }

    public Cart getCart(Long userId){
        return cartRepository.findByUserId(userId);
    }

    public Iterable<Cart> getAllCart(){
        return cartRepository.findAll();
    }
}
