package com.example.service;

import com.example.exceptions.CartResult;
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

    public CartResult addToCart(Long productId, Long userId){
        Product product = productsService.getProductById(productId);
        if(product == null){
            return null;
        }
        Cart newCart = new Cart();
        newCart.setPrice(product.getPrice());
        newCart.setProduct(product);
        newCart.setUserId(userId);

        Cart entity = cartRepository.save(newCart);
        return new CartResult("Success!", entity);
    }

    public CartResult removeFromCart(Long userId){
        int result = cartRepository.deleteByUserId(userId);
        if(result==1){
            return new CartResult("Successfully deleted!");
        }
        else{
            return new CartResult("Deletion failed! No such cart with specified userId given.");
        }

    }

    public CartResult getCart(Long userId){
        Cart result = cartRepository.findByUserId(userId);
        return new CartResult("Success", result);
    }

    public Iterable<Cart> getAllCart(){
        return cartRepository.findAll();
    }
}
